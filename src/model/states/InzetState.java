package model.states;

import model.Spel;
import model.gokstrategies.GokStrategy;

public class InzetState implements State {
    private Spel spel;

    public InzetState(Spel spel) {
        this.spel = spel;
    }

    @Override
    public void enterInzet(int inzet) {
        spel.setInzet(inzet);
        spel.setState(spel.getChooseState());
    }
}
