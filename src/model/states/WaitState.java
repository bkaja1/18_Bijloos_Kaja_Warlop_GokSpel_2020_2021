package model.states;

import model.Spel;

public class WaitState implements State {
    private Spel spel;

    public WaitState(Spel spel) {
        this.spel = spel;
    }

    @Override
    public void startNewGame() {
        spel.startNewGame();
        spel.setState(spel.getSpelerState());
    }

    @Override
    public void closeApp() {
        spel.closeApp();
    }
}
