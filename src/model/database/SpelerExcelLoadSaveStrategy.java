package model.database;

import excel.ExcelPlugin;
import model.Speler;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SpelerExcelLoadSaveStrategy implements LoadSaveStrategy {
    private ExcelPlugin excelPlugin;

    @Override
    public Map load(File file) {
        excelPlugin = new ExcelPlugin();
        Map<Object, Object> returnMap = new HashMap<>();
        try {
            for(ArrayList<String> tokens : excelPlugin.read(file)) {
                Speler element = new Speler(tokens.get(0), tokens.get(1), tokens.get(2), Integer.parseInt(tokens.get(3)));
                String key = tokens.get(2);
                returnMap.put(key, element);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnMap;
    }

    @Override
    public void save(File file, ArrayList<Object> objects) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for(Object object : objects) {
            Speler speler = (Speler) object;
            ArrayList<String> tokens = new ArrayList<>();
            tokens.add(speler.getFamilienaam());
            tokens.add(speler.getVoornaam());
            tokens.add(speler.getSpelernaam());
            tokens.add(Integer.toString(speler.getGoksaldo()));
            result.add(tokens);
        }
        try {
            excelPlugin.write(file, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
