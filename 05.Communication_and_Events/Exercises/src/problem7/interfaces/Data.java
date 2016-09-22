package problem7.interfaces;

import java.util.Set;

public interface Data {
    void addObserver(Observer observer);
    Observer getObserver(String id);
    void addOservable(Observable observable);
    Observable getObservable(String id);
    void subscribeObserver(Observer observer);
    Set<String> getObservers();

}
