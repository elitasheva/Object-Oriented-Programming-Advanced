package problem2.models;

import problem2.events.DeadEvent;
import problem2.interfaces.DeadListener;
import java.util.LinkedHashMap;

public class CustomMap<K, V> extends LinkedHashMap<K, V> implements DeadListener{
    @Override
    public void handleWithDead(DeadEvent deadEvent) {
        this.remove(deadEvent);
    }
}
