package model.states;

import model.gokstrategies.GokStrategy;

public interface State {
    default void startNewGame() {
        throw new IllegalArgumentException("Je kan geen nieuwe spel starten");
    }

    default void closeApp() {
        throw new IllegalArgumentException("Je kan geen spel sluiten");
    }

    default void enterSpelernaam(String spelernaam) {
        throw new IllegalArgumentException("Je kan geen spelernaam ingeven");
    }

    default void enterInzet(int inzet) {
        throw new IllegalArgumentException("Je kan geen inzet ingeven");
    }

    default void start() {
        throw new IllegalArgumentException("Je kan niet starten");
    }

    default void confirmChoice(GokStrategy gokStrategy) {
        throw new IllegalArgumentException("Je kan geen gokstrategy kiezen");
    }

    default void throwDice(int i) {
        throw new IllegalArgumentException("Je kan geen dobbelsteen gooien");
    }
}
