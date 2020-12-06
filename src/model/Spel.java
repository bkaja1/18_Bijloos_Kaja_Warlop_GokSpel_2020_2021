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
    private int nummer;
    private Speler speler;

    public Spel() {
        this.spelerDB = new SpelerDB();
        this.observers = new ArrayList<>();
        this.nummer = 1;
        setLoadSaveStrategy(createLoadSave(LoadSaveEnum.SPELERTEKST.toString()));
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
    public void notifyObservers(Object object) {
        for(Observer observer : observers) {
            observer.update(object);
        }
    }

    public void setLoadSaveStrategy(LoadSaveStrategy loadSaveStrategy) {
        spelerDB.setLoadSaveStrategy(loadSaveStrategy);
    }

    public int getNummer() {
        return nummer;
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

    public void setSpeler(String spelernaam) {
        this.speler = getSpeler(spelernaam);
        notifyObservers(this);
    }

    public String getFamilienaam() {
        return speler.getFamilienaam();
    }

    public String getVoornaam() {
        return speler.getVoornaam();
    }

    public String getSpelernaam() {
        return speler.getSpelernaam();
    }

    public int getGoksaldo() {
        return speler.getGoksaldo();
    }

    public int getInzet() {
        return speler.getInzet();
    }

    public void setInzet(int inzet) {
        speler.setInzet(inzet);
        notifyObservers(this);
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

    public void updateDisplay(Object object) {
        notifyObservers(object);
    }
}
