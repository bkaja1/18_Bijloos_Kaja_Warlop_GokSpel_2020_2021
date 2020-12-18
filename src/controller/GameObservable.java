package controller;

public interface GameObservable {
    void addGameObserver(GameObserver o);
    void deleteGameObserver(GameObserver o);
    void notifyGameObservers(Object object);
}
