package problem7.core;

import problem7.interfaces.Data;
import problem7.interfaces.Observable;
import problem7.interfaces.Observer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class Database implements Data {
    HashMap<String, Observer> observers;
    HashMap<String, Observable> obsevables;

    public Database() {
        this.observers = new HashMap<>();
        this.obsevables = new HashMap<>();
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.put(observer.getId(), observer);
    }

    @Override
    public Observer getObserver(String id) {
        return this.observers.get(id);
    }

    @Override
    public void addOservable(Observable observable) {
        this.obsevables.put(observable.getId(), observable);
    }

    @Override
    public Observable getObservable(String id) {
        return this.obsevables.get(id);
    }

    @Override
    public void subscribeObserver(Observer observer) {
        for (String id : obsevables.keySet()) {
            this.obsevables.get(id).addObserver(observer);
        }
    }

    @Override
    public Set<String> getObservers() {
        return this.observers.keySet();
    }
}
