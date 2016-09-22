package problem1.models;

import problem1.events.NameChangeEvent;
import problem1.interfaces.NameChangeListener;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {

    private String name;
    List<NameChangeListener> subscribers;

    public Dispatcher() {
        this.subscribers = new ArrayList<>();
        this.setName(null);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
        this.fireNameChangeEvent();
    }

    public void addNameChangeListener(NameChangeListener subscriber){
        this.subscribers.add(subscriber);
    }

    public void removeNameChangeListener(NameChangeListener subscriber){
        this.subscribers.remove(subscriber);
    }

    private void fireNameChangeEvent(){
        NameChangeEvent event = new NameChangeEvent(this, getName());
        for (NameChangeListener subscriber : subscribers) {
            subscriber.handleChangedName(event);
        }
    }
}
