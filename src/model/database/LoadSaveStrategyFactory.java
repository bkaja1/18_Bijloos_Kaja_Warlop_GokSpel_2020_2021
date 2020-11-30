package model.database;

public class LoadSaveStrategyFactory {
    private static LoadSaveStrategyFactory instance = null;
    private LoadSaveStrategy loadSave = null;

    private LoadSaveStrategyFactory() {}

    public static LoadSaveStrategyFactory getInstance() {
        if(instance == null) {
            instance = new LoadSaveStrategyFactory();
        }
        return instance;
    }

    public LoadSaveStrategy create(String type) {
        LoadSaveEnum lsType = LoadSaveEnum.valueOf(type);
        String klasseNaam = lsType.getKlasseNaam();
        try {
            Class dbKlasseNaam = Class.forName(klasseNaam);
            Object object = dbKlasseNaam.newInstance();
            loadSave = (LoadSaveStrategy)object;
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return loadSave;
    }
}
