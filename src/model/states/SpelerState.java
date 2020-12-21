package model.states;

import model.Spel;

public class SpelerState implements State {
    private Spel spel;

    public SpelerState(Spel spel) {
        this.spel = spel;
    }

    @Override
    public void enterSpelernaam(String spelernaam) {
        spel.setSpeler(spelernaam);
        spel.setState(spel.getInzetState());
        spel.notifyObservers();
    }
}
