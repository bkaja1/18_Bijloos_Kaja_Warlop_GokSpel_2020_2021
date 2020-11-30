package model;

import controller.Observable;
import controller.Observer;

import java.util.ArrayList;

public class Spel implements Observable {
    private ArrayList<Observer> observers;
    private Speler speler;

    public Spel() {
        this.observers = new ArrayList<>();
        this.speler = new Speler(); //lege constructor in Speler maken?
    }

    @Override
    public void addObserver(Observer o) {

    }

    @Override
    public void deleteObservers(Observer o) {
        this.observers.remove(o);
    }

    @Override
    public void notifyObservers() {

    }
}
