package controller;

import model.Spel;
import view.panels.SpelverloopPane;

/**
 * @Author Blenda Kaja
 *         Sébastien Warlop
 */

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

    public void startNewGame(){
        spel.getState().startNewGame();
    }

    public void closeGame() {
        spel.getState().closeGame();
    }

    @Override
    public void update() {
        if(spel.getState() == spel.getSpelerState()) {
            view.startNewGame();
        }
        if(spel.getState() == spel.getChooseState() || spel.getState() == spel.getPlayState()) {
            view.display(spel);
        }
        if(spel.getState() == spel.getWaitState()) {
            view.displayGewonnen(spel);
        }
        if(spel.getState() == spel.getClosedState()) {
            view.closeGame();
        }
    }
}
