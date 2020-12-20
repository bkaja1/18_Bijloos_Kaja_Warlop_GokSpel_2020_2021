package controller;

import model.Spel;

import view.panels.StatistiekPane;

public class StatistiekController implements WaitObserver {
    private StatistiekPane view;
    private Spel spel;

    public StatistiekController(Spel spel) {
        this.spel = spel;
        spel.addWaitObserver(this);

    }

    public void setView(StatistiekPane view) {
        this.view = view;
        view.refresh(spel);
    }

    @Override
    public void updateWait(String wait) {
        if(wait.equals("gewonnen")) {
            view.refresh(spel);
        }
    }
}
