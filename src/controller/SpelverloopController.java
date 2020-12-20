package controller;

import model.Spel;
import view.panels.SpelverloopPane;

/**
 * @Author Blenda Kaja
 *         Sébastien Warlop
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

    public void startNewGame(){
        spel.getState().startNewGame();
    }

    public void closeGame() {
        spel.getState().closeGame();
    }

    @Override
    public void updateWait(String wait) {
        if(wait.equals("start")) {
            view.startNewGame();
        }
        if(wait.equals("gewonnen")) {
            view.displayGewonnen(spel);
        }
        if(wait.equals("close")) {
            view.closeGame();
        }
    }

    @Override
    public void updateGame(Object object) {
        view.display(spel);
    }
}
