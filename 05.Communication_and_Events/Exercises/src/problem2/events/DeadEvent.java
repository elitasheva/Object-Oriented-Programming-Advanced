package problem2.events;

import java.util.EventObject;

public class DeadEvent extends EventObject {

    private String name;

    public DeadEvent(Object source, String name) {
        super(source);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
