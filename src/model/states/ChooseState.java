package model.states;

import model.Spel;
import model.gokstrategies.GokStrategy;

/**
 * @Author Blenda Kaja
 */

public class ChooseState implements State {
    private Spel spel;

    public ChooseState(Spel spel) {
        this.spel = spel;
    }

    @Override
    public void confirmChoice(GokStrategy gokStrategy) {
        spel.setGokStrategy(gokStrategy);
        spel.setState(spel.getPlayState());
        spel.notifyObservers();
    }
}
