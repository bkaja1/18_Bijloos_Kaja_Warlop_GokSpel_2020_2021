package model.database;

public class LoadSaveStrategyFactory {
    private static LoadSaveStrategyFactory uniqueInstance = null;

    public static LoadSaveStrategyFactory getInstance() {
        if(uniqueInstance == null) {
            uniqueInstance = new LoadSaveStrategyFactory();
        }
        return uniqueInstance;
    }

    public LoadSaveStrategy createLoadSave(String type) {
        LoadSaveEnum loadSaveEnum = LoadSaveEnum.valueOf(type);
        String klasseNaam = loadSaveEnum.getKlasseNaam();
        LoadSaveStrategy loadSaveStrategy = null;
        try {
            Class dbKlasseNaam = Class.forName(klasseNaam);
            Object object = dbKlasseNaam.newInstance();
            loadSaveStrategy = (LoadSaveStrategy) object;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loadSaveStrategy;
    }
}
