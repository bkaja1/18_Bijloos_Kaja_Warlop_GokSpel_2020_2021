package model.gokstrategy;

public class GokFactory {
    public static GokStrategy createGokStrategy(String omschrijving) {
        GokEnum gokEnum = null;
        for(GokEnum gok : GokEnum.values()) {
            if(gok.getOmschrijving().equals(omschrijving)) {
                gokEnum = gok;
            }
        }
        String klasseNaam = gokEnum.getKlasseNaam();
        GokStrategy gokStrategy = null;
        try {
            Class dbClass = Class.forName(klasseNaam);
            Object dbObject = dbClass.newInstance();
            gokStrategy = (GokStrategy) dbObject;
        }
        catch (Exception e){}
        return gokStrategy;
    }
}
