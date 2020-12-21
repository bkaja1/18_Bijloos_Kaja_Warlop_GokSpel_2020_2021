package model.states;

import model.Spel;

public class ClosedState implements State {
    private Spel spel;

    public ClosedState(Spel spel) {
        this.spel = spel;
    }
}
