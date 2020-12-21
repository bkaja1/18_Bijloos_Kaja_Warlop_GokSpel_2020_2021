package controller;

import model.Spel;

import view.panels.StatistiekPane;

public class StatistiekController implements Observer {
    private StatistiekPane view;
    private Spel spel;

    public StatistiekController(Spel spel) {
        this.spel = spel;
        spel.addObserver(this);

    }

    public void setView(StatistiekPane view) {
        this.view = view;
        view.refresh(spel);
    }

    @Override
    public void update(String s) {
        if(spel.getState() == spel.getWaitState()) {
            view.refresh(spel);
        }
    }
}
