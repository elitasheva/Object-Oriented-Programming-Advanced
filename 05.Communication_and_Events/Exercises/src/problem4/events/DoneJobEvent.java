package problem4.events;

import java.util.EventObject;

public class DoneJobEvent extends EventObject {

    public DoneJobEvent(Object source) {
        super(source);
    }
}
