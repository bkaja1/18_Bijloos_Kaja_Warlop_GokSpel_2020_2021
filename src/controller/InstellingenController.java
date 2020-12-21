package controller;

import model.Spel;
import view.panels.InstellingenPane;

import java.io.FileNotFoundException;
import java.util.List;

public class InstellingenController implements Observer {
    private InstellingenPane view;
    private Spel spel;

    public InstellingenController(Spel spel) {
        this.spel = spel;
        spel.addObserver(this);
    }

    public void setView(InstellingenPane view) {
        this.view = view;
    }

    public List<String> getLoadSaveLijst() {
        return spel.getLoadSaveLijst();
    }

    public void setProperty(String key, String value) {
        spel.setProperty(key, value);
    }

    @Override
    public void update() {
        if(spel.getNummer() == 1 && spel.getState() == spel.getSpelerState()) {
            view.setDisableSaveButton(false);
        }
        else if(spel.getState() == spel.getWaitState()) {
            view.setDisableSaveButton(false);
        }
        else view.setDisableSaveButton(true);
    }
}
