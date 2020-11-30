package controller;

import javafx.event.EventType;

public interface Observable {

    void voegObserverToe(EventType e, Observer o);
    void updateObserver(EventType e, Object o);
    void verwijderObserver(EventType e, Observer o);
}
