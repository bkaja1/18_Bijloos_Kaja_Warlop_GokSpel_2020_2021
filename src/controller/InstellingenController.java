package controller;

import model.Spel;
import view.panels.InstellingenPane;

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

    @Override
    public void update(String s) {
        if(spel.getState() == spel.getWaitState()) {
            view.setDisableSaveButton(false);
        } else view.setDisableSaveButton(true);
    }
}
