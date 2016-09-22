package problem.models;

import problem.events.DragonDeathEvent;
import problem.interfaces.DragonDeathListener;

import java.util.ArrayList;
import java.util.List;

public class Dragon {

    private String name;
    private int power;
    private int healthPoints;
    private Item item;
    private int initialHealth;
    private List<DragonDeathListener> listeners;

    public Dragon(String name, int power, int healthPoints, Item item) {
        this.setName(name);
        this.setPower(power);
        this.setHealthPoints(healthPoints);
        this.setItem(item);
        this.initialHealth = healthPoints;
        this.listeners = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getPower() {
        return this.power;
    }

    public int getHealthPoints() {
        return this.healthPoints;
    }

    public Item getItem() {
        return this.item;
    }

    public int getInitialHealth() {
        return this.initialHealth;
    }

    public void addDragonDeathListener(DragonDeathListener listener){
        this.listeners.add(listener);
    }

    public void removeDragonDeathListener(DragonDeathListener listener){
        this.listeners.remove(listener);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setPower(int power) {
        this.power = power;
    }

    public void setHealthPoints(int healthPoints) {
        if (healthPoints <= 0){
            this.fireDragonDeathEvenet();
        }else {
            this.healthPoints = healthPoints;
        }

    }

    private void fireDragonDeathEvenet() {
        System.out.println(String.format("%s died", this.getName()));
        DragonDeathEvent dragonEvent = new DragonDeathEvent(this, this.getItem());
        for (DragonDeathListener listener : listeners) {
            listener.handleWithTheDeadDragon(dragonEvent);
        }
    }

    private void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return String.format("%s %d", this.getName(), this.getHealthPoints());
    }

    public void respondToAttack(Warrior warrior){
        int damage = warrior.getPower();
        System.out.println(String.format("%s attacked %s for %d damage",
                warrior.getName(), this.getName(), damage));
        this.setHealthPoints(this.getHealthPoints() - damage);
    }
}
