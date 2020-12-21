package controller;

import model.Spel;
import view.GamblerView;

/**
 * @Author Blenda Kaja
 */

public class GamblerController implements Observer {
    private GamblerView view;
    private Spel spel;

    public GamblerController(Spel spel) {
        this.spel = spel;
        spel.addObserver(this);
    }

    public void setView(GamblerView view) {
        this.view = view;
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

    @Override
    public void update() {
        if(spel.getState() == spel.getSpelerState()) {
            view.refresh();
        }
        if(spel.getState() == spel.getInzetState()) {
            view.displayGoksaldo(spel.getGoksaldo());
            view.setEditableInzet(true);
        }
        if(spel.getState() == spel.getChooseState()) {
            view.setEditableInzet(false);
            view.setDisableStartButton(false);
        }
        if(spel.getState() == spel.getPlayState()) {
            view.setDisableStartButton(true);
            view.setEditableInzet(spel.getWorpen().size() == 2);
        }
        if(spel.getState() == spel.getWaitState()) {
            view.displayResult(spel.isGewonnen(), spel.getGoksaldo());
        }
    }
}
