package problem2.interfaces;

import problem2.events.DeadEvent;

public interface DeadListener {

    void handleWithDead(DeadEvent deadEvent);
}
