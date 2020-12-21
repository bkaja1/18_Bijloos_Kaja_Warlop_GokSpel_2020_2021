package model.states;

import model.Spel;

public class WaitState implements State {
    private Spel spel;

    public WaitState(Spel spel) {
        this.spel = spel;
    }

    @Override
    public void startNewGame() {
        spel.setState(spel.getSpelerState());
        spel.startNewGame();
    }

    @Override
    public void closeGame() {
        spel.setState(spel.getClosedState());
        spel.closeGame();
    }
}
