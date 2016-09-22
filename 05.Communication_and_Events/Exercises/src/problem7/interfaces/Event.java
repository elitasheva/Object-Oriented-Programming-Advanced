package problem7.interfaces;

import java.lang.reflect.Field;

public interface Event<T> {
    Observable getSource();
    Field getChangedField();
    T getOldValue();
    T getNewValue();
}
