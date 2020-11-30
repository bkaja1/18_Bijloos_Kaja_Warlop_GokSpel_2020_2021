package model;

import controller.Observable;
import controller.Observer;
import model.database.LoadSaveEnum;
import model.database.LoadSaveFactory;
import model.database.LoadSaveStrategy;
import model.database.SpelerDB;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Spel implements Observable {
    private SpelerDB spelerDB;
    private ArrayList<Observer> observers;

    public Spel() {
        this.spelerDB = new SpelerDB();
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void deleteObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(Speler speler) {
        for(Observer observer : observers) {
            observer.update(speler);
        }
    }

    public Map<String, Speler> getSpelersMap() {
        return spelerDB.getSpelersMap();
    }

    public ArrayList<Speler> getSpelers() {
        return spelerDB.getSpelers();
    }

    public void addSpeler(Speler speler) {
        spelerDB.addSpeler(speler);
    }

    public Speler getSpeler(String spelernaam) {
        return spelerDB.getSpeler(spelernaam);
    }

    public String getFamilienaam(String spelernaam) {
        return spelerDB.getSpeler(spelernaam).getFamilienaam();
    }

    public String getVoornaam(String spelernaam) {
        return spelerDB.getSpeler(spelernaam).getVoornaam();
    }

    public int getGoksaldo(String spelernaam) {
        return spelerDB.getSpeler(spelernaam).getGoksaldo();
    }

    public List<String> getLoadSaveLijst(){
        List<String> loadSaveLijst = new ArrayList<>();
        for (LoadSaveEnum loadSave: LoadSaveEnum.values()){
            loadSaveLijst.add(loadSave.toString());
        }
        return loadSaveLijst;
    }

    public LoadSaveStrategy createLoadSave(String type) {
        return LoadSaveFactory.getInstance().createLoadSave(type);
    }

    public void updateDisplay(String spelernaam) {
        notifyObservers(getSpeler(spelernaam));
    }
}
