package model;

import controller.Observable;
import controller.Observer;
import model.database.LoadSaveEnum;
import model.database.LoadSaveFactory;
import model.database.LoadSaveStrategy;
import model.database.SpelerDB;
import model.gokstrategy.GokEnum;
import model.gokstrategy.GokFactory;
import model.gokstrategy.GokStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Spel implements Observable {
    private int nummer;
    private ArrayList<Observer> observers;
    private SpelerDB spelerDB;
    private Speler speler;
    private GokStrategy gokStrategy;

    public Spel() {
        this.spelerDB = new SpelerDB();
        this.observers = new ArrayList<>();
        this.nummer = 1;
        setLoadSaveStrategy(createLoadSaveStrategy(LoadSaveEnum.SPELERTEKST.toString()));
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

    public GokStrategy getGokStrategy() {
        return gokStrategy;
    }

    public void setGokStrategy(GokStrategy gokStrategy) {
        this.gokStrategy = gokStrategy;
        notifyObservers(this);
    }

    public String getGokOmschrijving() {
        String omschrijving = null;
        for(GokEnum gok : GokEnum.values()) {
            if(gok.getKlasseNaam().equals(gokStrategy.getClass().getName())) {
                omschrijving = gok.getOmschrijving();
            }
        }
        return omschrijving;
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

    public LoadSaveStrategy createLoadSaveStrategy(String type) {
        return LoadSaveFactory.getInstance().createLoadSaveStrategy(type);
    }

    public GokStrategy createGokStrategy(String omschrijving) {
        return GokFactory.createGokStrategy(omschrijving);
    }

    public void updateDisplay(Object object) {
        notifyObservers(object);
    }
}
