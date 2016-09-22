package problem7.interfaces;

import java.lang.reflect.Field;

public interface Observable extends Identifiable, Nameable{
    <T> void fireEvent(Field field, T oldValue, T newValue);
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
}
