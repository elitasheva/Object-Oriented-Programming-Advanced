package problem2.events;

import java.util.EventObject;

public class AttackEvent extends EventObject{

    public AttackEvent(Object source) {
        super(source);
    }
}
