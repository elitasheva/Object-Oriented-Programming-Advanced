package problem1.interfaces;

import problem1.events.NameChangeEvent;

public interface NameChangeListener {

    void handleChangedName(NameChangeEvent event);
}
