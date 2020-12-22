package model;

import controller.Observable;
import controller.Observer;
import model.database.LoadSaveEnum;
import model.database.LoadSaveFactory;
import model.database.LoadSaveStrategy;
import model.database.SpelerDB;
import model.gokstrategies.*;
import model.states.*;

import java.io.*;
import java.util.*;

public class Spel implements Observable {
    private ArrayList<Observer> observers;
    private SpelerDB spelerDB;
    private Speler speler;
    private int nummer;
    private ArrayList<Integer> worpen;
    private boolean gewonnen;
    private GokStrategy gokStrategy;
    private Map<String, GokStrategy> gokStrategies;
    private Map<String, GokStrategy> selectedGokStrategies;
    private State waitState;
    private State spelerState;
    private State inzetState;
    private State chooseState;
    private State playState;
    private State closedState;
    private State state;
    private Properties properties;

    public Spel() {
        this.observers = new ArrayList<>();
        this.spelerDB = new SpelerDB();
        this.nummer = 1;
        this.worpen = new ArrayList<>();
        this.gokStrategies = new LinkedHashMap<>();
        gokStrategies.put(GokEnum.EVENSTRATEGY.getOmschrijving(), new EvenStrategy());
        gokStrategies.put(GokEnum.SOMIS21STRATEGY.getOmschrijving(), new SomIs21Strategy());
        gokStrategies.put(GokEnum.HOGERDANVORIGESTRATEGY.getOmschrijving(), new HogerDanVorigeStrategy());
        gokStrategies.put(GokEnum.HOGERDANEENSTRATEGY.getOmschrijving(), new HogerDanEenStrategy());
        gokStrategies.put(GokEnum.SOMISMINSTENS6STRATEGY.getOmschrijving(), new SomIsMin6Strategy());
        setWaitState(new WaitState(this));
        setSpelerState(new SpelerState(this));
        setInzetState(new InzetState(this));
        setChooseState(new ChooseState(this));
        setPlayState(new PlayState(this));
        setClosedState(new ClosedState(this));
        setState(spelerState);
        properties = new Properties();
        selectedGokStrategies = new LinkedHashMap<>();
        if(getProperty("loadSave") != null) {
            setLoadSaveStrategy(createLoadSaveStrategy(getProperty("loadSave")));
        }
        addSelectedGokStrategies();
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
    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update();
        }
    }

    public Map<String, Speler> getSpelersMap() {
        return spelerDB.getSpelersMap();
    }

    public List<Speler> getSpelersList() {
        return spelerDB.getSpelersList();
    }

    public void addSpeler(Speler speler) {
        spelerDB.addSpeler(speler);
    }

    public Speler getSpeler(String spelernaam) {
        return spelerDB.getSpeler(spelernaam);
    }

    public Speler getSpeler() {
        return speler;
    }

    public void setSpeler(String spelernaam) {
        if(getSpelersList().size() == 0) {
            throw new IllegalArgumentException("Selecteer formaat in de instellingen tab");
        }
        if(getSelectedGokStrategies().size() == 0) {
            throw new IllegalArgumentException("Selecteer een of meerdere gokstrategieën in de instellingen tab");
        }
        this.speler = getSpeler(spelernaam);
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

    public void addGoksaldo(int i) {
        speler.addGoksaldo(i);
    }

    public int getInzet() {
        return speler.getInzet();
    }

    public void setInzet(int inzet) {
        if(worpen.size() == 2) {
            if(inzet < getInzet()) {
                throw new IllegalArgumentException("Inzet moet verhoogd worden");
            }
            if(inzet - getInzet() > 10) {
                throw new IllegalArgumentException("Inzet mag met maximum 10 € verhoogd worden");
            }
        }
        speler.setInzet(inzet);
    }

    public int getNummer() {
        return nummer;
    }

    public ArrayList<Integer> getWorpen() {
        return worpen;
    }

    public String getWorpenToString() {
        String result = "";
        for(Integer worp: worpen) {
            result += " " + worp;
        }
        return result;
    }

    public void addWorp(int i) {
        worpen.add(i);
        notifyObservers();
    }

    public boolean isGewonnen() {
        return gewonnen;
    }

    public void setGewonnen(boolean gewonnen) {
        this.gewonnen = gewonnen;
        if(gewonnen) {
            addGoksaldo(getInzet()*gokStrategy.getWinstfactor());
        } else {
            addGoksaldo(-getInzet());
        }
        addSpeler(speler);
        gokStrategies.get(gokStrategy.getOmschrijving()).addGekozen();
        if(gewonnen) {
            gokStrategies.get(gokStrategy.getOmschrijving()).addGewonnen();
        }
        gokStrategies.get(gokStrategy.getOmschrijving()).addInzet(speler.getInzet());
        if(gewonnen) {
            gokStrategies.get(gokStrategy.getOmschrijving()).addBedrag(speler.getInzet()*gokStrategy.getWinstfactor());
        }
    }

    public void startNewGame() {
        addSelectedGokStrategies();
        if(selectedGokStrategies.size() == 0) {
            //throw new IllegalArgumentException("Selecteer een of meerdere gokstrategieën in de instellingen tab");
        }
        nummer++;
        speler = null;
        worpen = new ArrayList<>();
        gewonnen = false;
        gokStrategy = null;
        setLoadSaveStrategy(createLoadSaveStrategy(getProperty("loadSave")));
    }

    public GokStrategy getGokStrategy() {
        return gokStrategy;
    }

    public void setGokStrategy(GokStrategy gokStrategy) {
        this.gokStrategy = selectedGokStrategies.get(gokStrategy.getOmschrijving());
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

    public GokStrategy createGokStrategy(String omschrijving) {
        return GokFactory.createGokStrategy(omschrijving);
    }

    public ArrayList<GokStrategy> getGokStrategies() {
        return new ArrayList<>(gokStrategies.values());
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getWaitState() {
        return waitState;
    }

    public void setWaitState(State waitState) {
        this.waitState = waitState;
    }

    public State getSpelerState() {
        return spelerState;
    }

    public void setSpelerState(State spelerState) {
        this.spelerState = spelerState;
    }

    public State getInzetState() {
        return inzetState;
    }

    public void setInzetState(State inzetState) {
        this.inzetState = inzetState;
    }

    public State getChooseState() {
        return chooseState;
    }

    public void setChooseState(State chooseState) {
        this.chooseState = chooseState;
    }

    public State getPlayState() {
        return playState;
    }

    public void setPlayState(State playState) {
        this.playState = playState;
    }

    public State getClosedState() {
        return closedState;
    }

    public void setClosedState(State closedState) {
        this.closedState = closedState;
    }

    public String getProperty(String key) {
        try {
            InputStream is = new FileInputStream("src/bestanden/settings.properties");
            properties.load(is);
            is.close();
        } catch (FileNotFoundException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        Object type = properties.getProperty(key);
        return (String) type;
    }

    public void setLoadSaveProperty(String value) {
        if(value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Selecteer formaat in de instellingen tab");
        }
        try{
            OutputStream os = new FileOutputStream("src/bestanden/settings.properties");
            properties.setProperty("loadSave", value);
            properties.store(os, "");
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(nummer == 1 && getState() == getSpelerState()) {
            setLoadSaveStrategy(createLoadSaveStrategy(value));
            notifyObservers();
        }
    }

    public void setGokStrategiesProperty(String value) {
        if(value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Selecteer een of meerdere gokstrategieën in de instellingen tab");
        }
        try{
            OutputStream os = new FileOutputStream("src/bestanden/settings.properties");
            properties.setProperty("gokStrategies", value);
            properties.store(os, "");
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(nummer == 1 && getState() == getSpelerState()) {
            addSelectedGokStrategies();
            notifyObservers();
        }
    }

    public void addSelectedGokStrategies() {
        selectedGokStrategies = new LinkedHashMap<>();
        if(getProperty("gokStrategies") != null && !getProperty("gokStrategies").trim().isEmpty()) {
            String[] values = getProperty("gokStrategies").split("!");
            for(String value: values) {
                String[] s = value.split(",");
                selectedGokStrategies.put(s[0], createGokStrategy(s[0]));
                selectedGokStrategies.get(s[0]).setWinstfactor(Integer.parseInt(s[1]));
            }
        }
    }

    public ArrayList<GokStrategy> getSelectedGokStrategies() {
        return new ArrayList<>(selectedGokStrategies.values());
    }

    public void setLoadSaveStrategy(LoadSaveStrategy loadSaveStrategy) {
        spelerDB.setLoadSaveStrategy(loadSaveStrategy);
    }

    public List<String> getLoadSaveLijst(){
        List<String> loadSaveLijst = new ArrayList<>();
        for(LoadSaveEnum loadSave: LoadSaveEnum.values()){
            loadSaveLijst.add(loadSave.toString());
        }
        return loadSaveLijst;
    }

    public LoadSaveStrategy createLoadSaveStrategy(String type) {
        return LoadSaveFactory.getInstance().createLoadSaveStrategy(type);
    }
}
