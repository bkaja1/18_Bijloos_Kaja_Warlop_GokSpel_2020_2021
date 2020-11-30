package model;

import controller.Observable;
import controller.Observer;

import java.util.ArrayList;

public class Spel implements Observable {
    private ArrayList<Observer> observers;
    private Speler speler;

    public Spel() {
        this.observers = new ArrayList<>();
        this.speler = new Speler();
    }
}
