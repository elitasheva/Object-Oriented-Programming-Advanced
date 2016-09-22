package problem1.events;

import java.util.EventObject;

public class NameChangeEvent extends EventObject{

    private String name;

    public NameChangeEvent(Object source, String newName) {
        super(source);
        this.name = newName;
    }

    public String getName() {
        return this.name;
    }
}
