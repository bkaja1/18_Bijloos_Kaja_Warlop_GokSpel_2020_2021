package controller;

import model.Spel;
import view.panels.SpelverloopPane;

public class SpelverloopController implements Observer {
    private SpelverloopPane view;
    private Spel spel;

    public SpelverloopController(Spel spel) {
        this.spel = spel;
        spel.addObserver(this);
    }

    public void setView(SpelverloopPane view) {
        this.view = view;
    }

    @Override
    public void update(Object object) {
        if(spel.getInzet() != 0) {
            view.display(spel);
        }
    }
}
