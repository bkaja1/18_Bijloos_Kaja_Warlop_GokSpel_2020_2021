package model.gokstrategy;

public class GokstrategyFactory {

    private VraagGokstrategy gokStrategy = new GewonnenStrategy();
    private Gokstrategy huidigegokStrategy;
    public boolean gameOver;

    /*public void GokStrategyFactory(){}*/

    public void werpDobbelsteen (int worp){
        this.gameOver = !gokStrategy.heeftGewonnen(worp);
    }

    public void setGokstrategy(Gokstrategy gokStrategy){
        try {
            Class strategyClass = Class.forName("model.gokstrategy." + gokStrategy.getStrategyKlasse());
            Object strategyObject = strategyClass.getConstructor().newInstance();
            this.gokStrategy = (VraagGokstrategy) strategyObject;
            this.huidigegokStrategy = gokStrategy;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Gokstrategy getGokStrategy(){
        return huidigegokStrategy;
    }
}
