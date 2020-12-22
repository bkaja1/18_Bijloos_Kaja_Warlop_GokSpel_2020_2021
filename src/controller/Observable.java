package controller;

/**
 * @Author Niels Bijloos
 */

public interface Observable {
    void addObserver(Observer o);
    void deleteObserver(Observer o);
    void notifyObservers();
}
