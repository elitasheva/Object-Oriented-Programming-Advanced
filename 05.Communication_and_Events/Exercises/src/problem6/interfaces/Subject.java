package problem6.interfaces;

import java.util.List;

public interface Subject {
    void addListener(Listener listener);
    void removeListener(Listener listener);
    void fireEvent(Spell spell, List<Listener> listeners);
}
