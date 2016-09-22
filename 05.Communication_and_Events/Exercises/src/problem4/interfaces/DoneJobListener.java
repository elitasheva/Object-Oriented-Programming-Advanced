package problem4.interfaces;

import problem4.events.DoneJobEvent;

public interface DoneJobListener {

    void handleEvent(DoneJobEvent event);
}
