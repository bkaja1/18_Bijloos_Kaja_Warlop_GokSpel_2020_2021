package model.database;

import model.Speler;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class SpelerDB {
    private LoadSaveStrategy loadSaveStrategy;
    private File file;
    private Map<String, Speler> spelers;

    public SpelerDB() {
        setLoadSaveStrategy(LoadSaveFactory.getInstance().createLoadSave("SPELERTEKST"));
        this.spelers = loadSaveStrategy.load(file);
    }

    public void setLoadSaveStrategy(LoadSaveStrategy loadSaveStrategy) {
        this.loadSaveStrategy = loadSaveStrategy;
        if(loadSaveStrategy instanceof SpelerTekstLoadSaveStrategy) {
            this.file = new File("src/bestanden/speler.txt");
        } else if(loadSaveStrategy instanceof  SpelerExcelLoadSaveStrategy) {
            this.file = new File("src/bestanden/speler.xls");
        }

    }

    public Map<String, Speler> getSpelersMap() {
        return spelers;
    }

    public ArrayList<Speler> getSpelers() {
        return (ArrayList<Speler>) spelers.values();
    }

    public void addSpeler(Speler speler) {
        if(speler == null) {
           throw new IllegalArgumentException("Speler is ongeldig");
        }
        spelers.put(speler.getSpelernaam(), speler);
        loadSaveStrategy.save(file, (ArrayList<Object>) spelers);
    }

    public Speler getSpeler(String spelernaam) {
        if(spelernaam == null || spelernaam.trim().isEmpty() || spelers.get(spelernaam) == null) {
            throw new IllegalArgumentException("Spelernaam is ongeldig");
        }
        return spelers.get(spelernaam);
    }
}
