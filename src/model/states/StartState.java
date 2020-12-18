package model.states;

import model.Spel;

public class StartState implements State {
    private Spel spel;

    public StartState(Spel spel) {
        this.spel = spel;
    }

    @Override
    public void start() {
        spel.setState(spel.getChooseState());
    }
}
