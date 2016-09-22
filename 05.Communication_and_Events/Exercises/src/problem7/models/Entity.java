package problem7.models;

import problem7.events.ChangeEvent;
import problem7.interfaces.Event;
import problem7.interfaces.Identifiable;
import problem7.interfaces.Observable;
import problem7.interfaces.Observer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class Entity implements Observable, Identifiable {

    private String id;
    private List<Observer> listeners;

    public Entity(String id) {
        this.id = id;
        this.listeners = new ArrayList<>();
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public <T> void fireEvent(Field field, T oldValue, T newValue) {
        Event<T> event = new ChangeEvent<T>(this, field, oldValue, newValue);
        for (Observer listener : listeners) {
            listener.update(event);
        }
    }

    @Override
    public void addObserver(Observer listener) {
        this.listeners.add(listener);
    }

    @Override
    public void removeObserver(Observer listener) {
        this.listeners.remove(listener);
    }

    <T> void fieldChanged(Class<?> fieldClass, String fieldName, T oldValue, T newValue) {
        try {
            Field currentField = fieldClass.getDeclaredField(fieldName);
            this.fireEvent(currentField, oldValue, newValue);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

}
