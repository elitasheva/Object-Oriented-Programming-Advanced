package problem4.datastucture;

import problem4.events.DoneJobEvent;
import problem4.interfaces.DoneJobListener;
import java.util.ArrayList;

public class CustomList<T> extends ArrayList<T> implements DoneJobListener {

    @Override
    public void handleEvent(DoneJobEvent event) {
        this.remove(event.getSource());
    }
}
