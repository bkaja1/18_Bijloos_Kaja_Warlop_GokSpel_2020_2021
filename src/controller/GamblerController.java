package controller;

import model.Spel;
import view.GamblerView;

public class GamblerController implements Observer {
    private GamblerView view;
    private Spel spel;

    public GamblerController(Spel spel) {
        this.spel = spel;
        spel.addObserver(this);
    }

    public void updateSpelernaam(String spelernaam) {
        spel.setSpeler(spelernaam);
    }

    public void updateInzet(String inzet) {
        try {
            spel.setInzet(Integer.parseInt(inzet));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Inzet is geen nummer");
        }
    }

    public void setView(GamblerView view) {
        this.view = view;
    }

    @Override
    public void update(Object object) {
        view.displayGoksaldo(spel.getGoksaldo());
        if(spel.getInzet() != 0) {
            view.displayStart();
        }
    }
}
