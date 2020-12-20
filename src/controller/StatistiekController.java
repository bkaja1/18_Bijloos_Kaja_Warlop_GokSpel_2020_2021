package controller;

import model.Spel;
import model.gokstrategies.GokStrategy;

import view.panels.StatistiekPane;

import java.util.ArrayList;
import java.util.HashMap;

public class StatistiekController implements WaitObserver, GameObserver{

    private StatistiekPane view;
    private Spel spel;

    private GamblerController gamblerController;

    private HashMap<GokStrategy, ArrayList<Double>> statistieken;

    public StatistiekController(Spel spel) {
        this.spel = spel;
        spel.addWaitObserver(this);
        spel.addGameObserver(this);
    }

    public void setView(StatistiekPane view) {
        this.view = view;
    }

    @Override
    public void updateGame(Object object) {

    }

    @Override
    public void updateWait(String wait) {

    }
}
