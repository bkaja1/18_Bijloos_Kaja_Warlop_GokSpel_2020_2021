package model.database;

import excel.ExcelPlugin;
import model.Speler;

import java.io.File;
import java.util.ArrayList;

public class SpelerExcelLoadSaveStrategy implements LoadSaveStrategy {

    private ExcelPlugin excelPlugin;
    private String path;

    public SpelerExcelLoadSaveStrategy(String path) {
        if(path.isEmpty()) {
            throw new IllegalArgumentException("Pad mag niet leeg zijn.");
        }
        this.path = path;
    }

    public SpelerExcelLoadSaveStrategy() {
        this("src/bestanden/spelers.xls");
    }

    @Override
    public ArrayList<Object> load() {
        excelPlugin = new ExcelPlugin();
        ArrayList<Object> resultaat = new ArrayList<>();
        try {
            ArrayList<ArrayList<String>> spelers = excelPlugin.read(new File(path));
            for(ArrayList<String> speler:spelers) {
                resultaat.add(new Speler(speler.get(0), speler.get(1), speler.get(2), Integer.parseInt(speler.get(3))));
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return resultaat;
    }

    @Override
    public void save(ArrayList<Object> spelers) {
        ArrayList<ArrayList<String>> resultaat = new ArrayList<>();
        for(Object o : spelers) {
            Speler speler1 = (Speler) o;
            ArrayList<String> speler = new ArrayList<>();
            speler.add(speler1.getFamilienaam());
            speler.add(speler1.getVoornaam());
            speler.add(speler1.getSpelernaam());
            speler.add(String.valueOf(speler1.getGoksaldo()));
            resultaat.add(speler);
        }
        try {
            excelPlugin.write(new File(path), resultaat);
        } catch (Exception exc ) {
            exc.printStackTrace();
        }
    }
}
