package controller;

import model.Spel;
import view.panels.SpelverloopPane;

/**
 * @Author Blenda Kaja
 */

public class SpelverloopController implements WaitObserver, GameObserver {
    private SpelverloopPane view;
    private Spel spel;

    public SpelverloopController(Spel spel) {
        this.spel = spel;
        spel.addWaitObserver(this);
        spel.addGameObserver(this);
    }

    public void setView(SpelverloopPane view) {
        this.view = view;
    }

    @Override
    public void updateWait(String wait) {
        if(wait.equals("end")) {
            view.displayGewonnen(spel);
        }
    }

    @Override
    public void updateGame(Object object) {
        view.display(spel);
    }
}
