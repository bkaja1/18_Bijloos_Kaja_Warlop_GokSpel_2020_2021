package model;

import controller.GameObservable;
import controller.GameObserver;
import controller.WaitObservable;
import controller.WaitObserver;
import model.database.LoadSaveEnum;
import model.database.LoadSaveFactory;
import model.database.LoadSaveStrategy;
import model.database.SpelerDB;
import model.gokstrategies.GokEnum;
import model.gokstrategies.GokFactory;
import model.gokstrategies.GokStrategy;
import model.states.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Spel implements WaitObservable, GameObservable {
    private int nummer;
    private SpelerDB spelerDB;
    private Speler speler;
    private ArrayList<Integer> worpen;
    private boolean gewonnen;
    private ArrayList<WaitObserver> waitObservers;
    private ArrayList<GameObserver> gameObservers;
    private GokStrategy gokStrategy;
    private State waitState;
    private State spelerState;
    private State inzetState;
    private State startState;
    private State chooseState;
    private State playState;
    private State state;

    public Spel() {
        this.nummer = 1;
        this.spelerDB = new SpelerDB();
        this.worpen = new ArrayList<>();
        this.waitObservers = new ArrayList<>();
        this.gameObservers = new ArrayList<>();
        setLoadSaveStrategy(createLoadSaveStrategy(LoadSaveEnum.SPELERTEKST.toString()));
        setWaitState(new WaitState(this));
        setSpelerState(new SpelerState(this));
        setInzetState(new InzetState(this));
        setChooseState(new ChooseState(this));
        setPlayState(new PlayState(this));
        setState(spelerState);
    }

    @Override
    public void addWaitObserver(WaitObserver o) {
        waitObservers.add(o);
    }

    @Override
    public void deleteWaitObserver(WaitObserver o) {
        waitObservers.remove(o);
    }

    @Override
    public void notifyWaitObservers(String wait) {
        for(WaitObserver waitObserver : waitObservers) {
            waitObserver.updateWait(wait);
        }
    }

    @Override
    public void addGameObserver(GameObserver o) {
        gameObservers.add(o);
    }

    @Override
    public void deleteGameObserver(GameObserver o) {
        gameObservers.remove(o);
    }

    @Override
    public void notifyGameObservers(Object object) {
        for(GameObserver gameObserver : gameObservers) {
            gameObserver.updateGame(object);
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
        notifyGameObservers(this);
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

    public State getStartState() {
        return startState;
    }

    public void setStartState(State startState) {
        this.startState = startState;
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

    public int getNummer() {
        return nummer;
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
        this.speler = getSpeler(spelernaam);
        notifyGameObservers(this);
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

        notifyGameObservers(this);
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
        notifyGameObservers(this);
    }

    public boolean isGewonnen() {
        return gewonnen;
    }

    public void setGewonnen(boolean gewonnen) {
        this.gewonnen = gewonnen;
        if(gewonnen) {
            addGoksaldo(getInzet()*getGokEnum().getWinstfactor());
        } else {
            addGoksaldo(-getInzet());
        }
        spelerDB.addSpeler(speler);
        notifyWaitObservers("gewonnen");
    }

    public List<String> getLoadSaveLijst(){
        List<String> loadSaveLijst = new ArrayList<>();
        for(LoadSaveEnum loadSave: LoadSaveEnum.values()){
            loadSaveLijst.add(loadSave.toString());
        }
        return loadSaveLijst;
    }

    public GokEnum getGokEnum() {
        GokEnum gokEnum = null;
        for(GokEnum g: GokEnum.values()){
            if(g.getKlasseNaam().equals(gokStrategy.getClass().getName())) {
                gokEnum = g;
            }
        }
        return gokEnum;
    }

    public LoadSaveStrategy createLoadSaveStrategy(String type) {
        return LoadSaveFactory.getInstance().createLoadSaveStrategy(type);
    }

    public GokStrategy createGokStrategy(String omschrijving) {
        return GokFactory.createGokStrategy(omschrijving);
    }
}
