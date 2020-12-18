package controller;

public interface WaitObservable {
    void addWaitObserver(WaitObserver o);
    void deleteWaitObserver(WaitObserver o);
    void notifyWaitObservers(String wait);
}
