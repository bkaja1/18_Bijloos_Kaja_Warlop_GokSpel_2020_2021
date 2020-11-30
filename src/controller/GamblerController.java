package controller;

import view.GamblerView;

public class GamblerController implements Observer {
    private GamblerView view;
    /*
    private Spel spel;

    public GamblerController(Spel spel) {
        this.spel = spel;
        spel.addObserver(this);
    }
    */

    public void setView(GamblerView view) {
        this.view = view;
    }

    @Override
    public void update(Object object) {

    }
}
