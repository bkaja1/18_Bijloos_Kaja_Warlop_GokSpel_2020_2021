package controller;

import model.Spel;
import view.panels.GamblerOverviewPane;

/**
 * @Author Blenda Kaja
 */

public class GamblerOverviewController implements WaitObserver, GameObserver {
    private GamblerOverviewPane view;
    private Spel spel;

    public GamblerOverviewController(Spel spel) {
        this.spel = spel;
        spel.addWaitObserver(this);
        spel.addGameObserver(this);
    }

    public void setView(GamblerOverviewPane view) {
        this.view = view;
        view.refresh(spel);
    }

    @Override
    public void updateWait(String wait) {

    }

    @Override
    public void updateGame(Object object) {
        view.refresh(spel);
    }
}
