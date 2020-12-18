package controller;

import model.Spel;
import view.GamblerView;

/**
 * @Author Blenda Kaja
 */

public class GamblerController implements WaitObserver, GameObserver {
    private GamblerView view;
    private Spel spel;

    public GamblerController(Spel spel) {
        this.spel = spel;
        spel.addWaitObserver(this);
        spel.addGameObserver(this);
    }

    public void updateSpelernaam(String spelernaam) {
        spel.getState().enterSpelernaam(spelernaam);
    }

    public void updateInzet(String inzet) {
        try {
            spel.getState().enterInzet(Integer.parseInt(inzet));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Inzet is geen nummer");
        }
    }

    public void updateGokStrategy(String gokStrategy) {
        spel.getState().confirmChoice(spel.createGokStrategy(gokStrategy));
    }

    public void throwDice(int i) {
        spel.getState().throwDice(i);
    }

    public void setView(GamblerView view) {
        this.view = view;
    }

    @Override
    public void updateWait(String wait) {
        if(wait.equals("gewonnen")) {
            view.displayResult(spel.isGewonnen(), spel.getGoksaldo());
        }
    }

    @Override
    public void updateGame(Object object) {
        if(spel.getState() == spel.getSpelerState()) {
            view.displayGoksaldo(spel.getGoksaldo());
        }
        if(spel.getState() == spel.getInzetState()) {
            view.setEditableInzet(false);
            view.setDisableStartButton(false);
        }
        if(spel.getState() == spel.getPlayState()) {
            view.setEditableInzet(spel.getWorpen().size() == 2);
        }
    }
}
