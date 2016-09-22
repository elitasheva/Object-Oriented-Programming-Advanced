package problem6.models;

import problem6.factories.SpellFactory;
import problem6.interfaces.Listener;
import problem6.interfaces.Spell;
import problem6.interfaces.Wizard;

import java.util.ArrayList;
import java.util.List;

public class WizardImpl implements Wizard {

    private int id;
    private String name;
    private int power;
    List<Listener> listeners;

    public WizardImpl(int id, String name, int power) {
        this.id = id;
        this.name = name;
        this.power = power;
        this.listeners = new ArrayList<>();
    }


    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public void update(Spell spell) {
        Spell listenerSpell = SpellFactory.createSpell(this, spell.getSpellType());
        this.cast(listenerSpell);
    }

    @Override
    public int getReflectionsCount() {
        return this.listeners.size();
    }

    @Override
    public void cast(Spell spell) {
        List<Listener> copyListeners = new ArrayList<>();
        copyListeners.addAll(this.listeners);

        spell.cast();
        this.fireEvent(spell, copyListeners);

    }

    @Override
    public void addListener(Listener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void removeListener(Listener listener) {
        this.listeners.remove(listener);

    }

    @Override
    public void fireEvent(Spell spell, List<Listener> copyListeners) {
        for (Listener listener : copyListeners) {
            listener.update(spell);
        }
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getId();
    }
}
