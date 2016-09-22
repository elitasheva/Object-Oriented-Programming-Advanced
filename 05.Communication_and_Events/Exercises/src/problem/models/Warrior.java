package problem.models;

import problem.events.DragonDeathEvent;
import problem.events.WarriorDeathEvenet;
import problem.interfaces.DeathWarriorListener;
import problem.interfaces.DragonDeathListener;

import java.util.ArrayList;
import java.util.List;

public class Warrior implements DragonDeathListener, Comparable<Warrior> {

    private String name;
    private int experience;
    private int power;
    private int healthPoints;
    private List<Item> inventory;
    private List<DeathWarriorListener> listeners;

    public Warrior(String name, int experience, int power, int healthPoints) {
        this.setName(name);
        this.setExperience(experience);
        this.setPower(power);
        this.setHealthPoints(healthPoints);
        this.inventory = new ArrayList<>();
        this.listeners = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public int getPower() {
        return this.power;
    }

    public int getHealthPoints() {
        return this.healthPoints;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setExperience(int experience) {
        this.experience = experience;
    }

    private void setPower(int power) {
        this.power = power;
    }

    public void setHealthPoints(int healthPoints) {
        if (healthPoints <= 0) {
            this.fireWarriorEvent();

        } else {
            this.healthPoints = healthPoints;
        }

    }

    private void fireWarriorEvent() {
        System.out.println(String.format("%s died", this.getName()));
        WarriorDeathEvenet event = new WarriorDeathEvenet(this);
        for (DeathWarriorListener listener : listeners) {
            listener.handleWithTheDeadWarrior(event);
        }
    }

    public void addDeathWarriorListeners(DeathWarriorListener listener) {
        this.listeners.add(listener);
    }

    public void removeDeathWarriorListeners(DeathWarriorListener listener) {
        this.listeners.remove(listener);
    }

    @Override
    public void handleWithTheDeadDragon(DragonDeathEvent event) {
        Item currentItem = event.getItem();
        this.inventory.add(currentItem);
        Dragon dragon = (Dragon) event.getSource();
        //TODO how to avoid the cast????????
        this.setExperience(this.getExperience() + dragon.getInitialHealth());
        if (currentItem.getTypeBonus().toLowerCase().equals("power")) {
            this.setPower(this.getPower() + currentItem.getPoints());
        }
        if (currentItem.getTypeBonus().toLowerCase().equals("health")) {
            this.setHealthPoints(this.getHealthPoints() + currentItem.getPoints());
        }

        System.out.println(String.format("%s received %s from %s.",
                this.getName(), currentItem.getName(), dragon.getName()));
    }

    public void setAura(int power) {
        int powerFromAura = power / 10;
        this.setPower(this.getPower() + powerFromAura);
    }

    @Override
    public String toString() {
        return String.format("%s %d %d %d",
                this.getName(), this.getExperience(), this.getPower(), this.getHealthPoints());
    }

    @Override
    public int compareTo(Warrior other) {
        int compare = Integer.compare(this.getExperience(), other.getExperience());
        if (compare == 0) {
            compare = Integer.compare(this.getPower(), other.getPower());
            if (compare == 0) {
                compare = this.getName().compareTo(other.getName());
            }
        }

        return compare;
    }

    public void respondToAttack(Dragon dragon) {
        int damage = dragon.getPower();
        System.out.println(String.format("%s attacked %s for %d damage",
                dragon.getName(), this.getName(), damage));
        this.setHealthPoints(this.getHealthPoints() - damage);
    }
}
