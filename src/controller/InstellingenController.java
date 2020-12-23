package controller;

import model.Observer;
import model.Spel;
import view.panels.InstellingenPane;

/**
 * @Author Blenda Kaja
 */

public class InstellingenController implements Observer {
    private InstellingenPane view;
    private Spel spel;

    public InstellingenController(Spel spel) {
        this.spel = spel;
        spel.addObserver(this);
    }

    public void setView(InstellingenPane view) {
        this.view = view;
        view.setSelectedLoadSave(spel.getProperty("loadSave"));
        view.setSelectedGokStrategies(spel.getSelectedGokStrategies());
    }

    public void setLoadSaveProperty(String value) {
        spel.setLoadSaveProperty(value);
    }

    public void setGokStrategiesProperty(String value) {
        spel.setGokStrategiesProperty(value);
    }

    @Override
    public void update() {
    }
}
