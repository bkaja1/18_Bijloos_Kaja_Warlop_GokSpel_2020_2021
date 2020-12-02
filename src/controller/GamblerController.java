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
        spel.updateDisplay(spel.getSpeler(spelernaam));
    }

    public void updateInzet(String spelernaam, String inzet) {
        try {
            spel.setInzet(spelernaam, Integer.parseInt(inzet));
            spel.updateDisplay(null);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Inzet is geen nummer");
        }
    }

    public void setView(GamblerView view) {
        this.view = view;
    }

    @Override
    public void update(Object object) {
        if(object instanceof Speler) {
            view.displaySpelernaam(object);
        } else if(object == null) {
            view.displayInzet();
        }
    }
}
