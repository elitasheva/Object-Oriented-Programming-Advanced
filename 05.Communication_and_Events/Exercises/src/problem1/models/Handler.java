package problem1.models;

import problem1.events.NameChangeEvent;
import problem1.interfaces.NameChangeListener;

public class Handler implements NameChangeListener{

    @Override
    public void handleChangedName(NameChangeEvent event) {
        System.out.println(String.format("Dispatcher's name changed to %s.", event.getName()));
    }
}
