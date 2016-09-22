package problem2.models;

import problem2.events.AttackEvent;
import problem2.events.DeadEvent;
import problem2.interfaces.AttackListener;
import problem2.interfaces.Attackable;
import problem2.interfaces.DeadListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class King implements DeadListener, Attackable {

    private String name;
    private List<AttackListener> listeners;

    public King(String name) {
        this.name = name;
        this.listeners = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void addAttackListener(AttackListener listener) {
        this.listeners.add(listener);
    }

    public void removeAttackListener(AttackListener listener) {
        this.listeners.remove(listener);
    }

    public void respondToAttack() {
        System.out.println(String.format("King %s is under attack!", this.getName()));
        fireAttackEvenet();

    }

    private void fireAttackEvenet() {
        AttackEvent event = new AttackEvent(this);
        for (AttackListener listener : listeners) {
            listener.respondToAttack(event);
        }
    }

    @Override
    public void handleWithDead(DeadEvent deadEvent) {
        this.listeners.remove(deadEvent.getSource());

    }
}
