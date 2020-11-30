package controller;

public interface Observable {

    void addObserver(Observer o);
    void deleteObservers(Observer o);
    void notifyObservers();
}
