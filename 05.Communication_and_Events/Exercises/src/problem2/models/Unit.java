package problem2.models;

import problem2.events.DeadEvent;
import problem2.interfaces.AttackListener;
import problem2.interfaces.Attackable;
import problem2.interfaces.DeadListener;

import java.util.ArrayList;
import java.util.List;

public abstract class Unit implements AttackListener, Attackable {

    private String name;
    private int lives;
    private List<DeadListener> listeners;

    protected Unit(String name, int lives) {
        this.setName(name);
        this.setLives(lives);
        this.listeners = new ArrayList<>();
    }

    protected String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private int getLives() {
        return this.lives;
    }

    private void setLives(int lives) {
        this.lives = lives;
    }

    private void fireEvenet() {
        DeadEvent event = new DeadEvent(this, this.getName());
        for (DeadListener listener : listeners) {
            listener.handleWithDead(event);
        }
    }

    @Override
    public void respondToAttack() {
        this.setLives(this.getLives() - 1);
        if (this.getLives() <= 0) {
            this.fireEvenet();
        }
    }

    public void addListener(DeadListener listener) {
        this.listeners.add(listener);
    }

    public void removeListener(DeadListener listener){
        this.listeners.remove(listener);
    }
}
