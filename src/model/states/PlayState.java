package model.states;

import model.Spel;

public class PlayState implements State {
    private Spel spel;

    public PlayState(Spel spel) {
        this.spel = spel;
    }

    @Override
    public void enterInzet(int inzet) {
        if(spel.getWorpen().size() == 2) {
            spel.setInzet(inzet);
        } else throw new IllegalArgumentException("Je kan geen inzet ingeven");
    }

    @Override
    public void throwDice(int i) {
        spel.addWorp(i);
        if(!spel.getGokStrategy().evalueerGok(i)) {
            spel.setGewonnen(false);
            spel.setState(spel.getWaitState());
        } else if (spel.getWorpen().size() == 4) {
            spel.setGewonnen(spel.getGokStrategy().evalueerGok(i));
            spel.setState(spel.getWaitState());
        }
    }
}