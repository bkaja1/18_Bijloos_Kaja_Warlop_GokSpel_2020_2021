package model.states;

import model.Spel;

/**
 * @Author Blenda Kaja
 */

public class ClosedState implements State {
    private Spel spel;

    public ClosedState(Spel spel) {
        this.spel = spel;
    }
}
