package controller;

import model.Speler;

public interface Observable {
    void addObserver(Observer o);
    void deleteObserver(Observer o);
    void notifyObservers(Speler speler);
}
