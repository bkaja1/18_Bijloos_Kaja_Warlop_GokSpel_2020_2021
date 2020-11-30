package controller;

import model.Spel;
import model.Speler;
import view.GamblerView;

public class GamblerController implements Observer {
    private GamblerView view;
    private Spel spel;

    public GamblerController(Spel spel) {
        this.spel = spel;
        spel.addObserver(this);
    }

    public void updateSpelernaam(String spelernaam) {
        spel.updateDisplay(spelernaam);
    }

    public void setView(GamblerView view) {
        this.view = view;
    }

    @Override
    public void update(Speler speler) {
        view.displaySpelernaam(speler);
    }
}
