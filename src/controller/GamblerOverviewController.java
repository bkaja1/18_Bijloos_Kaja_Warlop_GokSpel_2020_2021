package controller;

import model.Spel;
import view.panels.GamblerOverviewPane;

/**
 * @Author Blenda Kaja
 */

public class GamblerOverviewController implements Observer {
    private GamblerOverviewPane view;
    private Spel spel;

    public GamblerOverviewController(Spel spel) {
        this.spel = spel;
        spel.addObserver(this);
    }

    public void setView(GamblerOverviewPane view) {
        this.view = view;
        update();
    }

    @Override
    public void update() {
        view.refresh(spel);
    }
}
