package model;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers;

    public Subject() {
        observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        if(!observers.contains(observer))
            observers.add(observer);
    }

    public void notifyObservers(Subject observable, double bid) {
        for(Observer observer : observers)
            observer.update(this, new Double(bid));
    }
}
