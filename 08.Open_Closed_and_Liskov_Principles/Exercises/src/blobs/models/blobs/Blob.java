package blobs.models.blobs;

import blobs.models.attacks.interfaces.Attack;
import blobs.models.behaviors.interfaces.Behavior;

public class Blob implements GameObject {

    private String name;
    private int health;
    private int damage;
    private Behavior behavior;
    private Attack attack;
    private int initialDamage;
    private int initialHealth;
    private boolean hasBehavior;

    public Blob(String name, int health, int damage, Behavior behavior, Attack attack) {
        this.name = name;
        this.initialHealth = health;
        this.setHealth(health);
        this.initialDamage = damage;
        this.setDamage(damage);
        this.behavior = behavior;
        this.attack = attack;
        this.hasBehavior = false;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {

        this.health = health;

        if (this.health < 0) {
            this.health = 0;
        }

        if (!hasBehavior && this.health <= initialHealth / 2) {
            hasBehavior = true;
            this.behavior.triggerBehavior();
        }

    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        if (damage >= this.initialDamage) {
            this.damage = damage;
        }

    }


    public boolean hasBehavior() {
        return this.hasBehavior;
    }

    public Behavior getBehavior() {
        return this.behavior;
    }

    @Override
    public void attack(GameObject targetBlob) {
        this.attack.produceAttack(targetBlob);

    }

    @Override
    public String toString() {
        //Blob {name}: {health} HP, {damage} Damage
        return String.format("Blob %s: %d HP, %d Damage", this.name, this.health, this.damage);
    }
}
