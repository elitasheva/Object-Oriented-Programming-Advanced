package problem10.models;

import problem10.annotations.CustomAnnotation;
import problem10.enums.Gem;


@CustomAnnotation(author = "Pesho",
        revision = 3,
        description = "Used for Java OOP Advanced course - Enumerations and Annotations.",
        reviewers = {"Pesho","Svetlio"})
public abstract class Weapon implements Comparable<Weapon> {

    private String name;
    private int minDamage;
    private int maxDamage;
    private int numberOfSockets;

    private Gem[] sockets;

    protected Weapon(String name, int minDamage, int maxDamage, int numberOfSockets) {
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.numberOfSockets = numberOfSockets;
        this.sockets = new Gem[numberOfSockets];
    }

    public String getName() {
        return this.name;
    }

    public void addGem(Gem gem, int index) {
        if (index >= 0 && index < this.numberOfSockets) {
            this.sockets[index] = gem;
        }

    }

    public void removeGem(int index) {
        if (index >= 0 && index < this.numberOfSockets) {
            this.sockets[index] = null;
        }

    }

    @Override
    public String toString() {

        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.name, this.getMinDamage(), this.getMaxDamage(),
                this.getStrength(), this.getAgility(), this.getVitality());
    }

    @Override
    public int compareTo(Weapon other) {
        return Double.compare(this.getLevel(), other.getLevel());
    }

    private int getStrength() {
        int strength = 0;
        for (Gem gem : sockets) {
            if (gem != null) {
                strength += gem.getStrength();
            }
        }
        return strength;
    }

    private int getAgility() {
        int agility = 0;
        for (Gem gem : sockets) {
            if (gem != null) {
                agility += gem.getAgility();
            }
        }
        return agility;
    }

    private int getVitality() {
        int vitality = 0;
        for (Gem gem : sockets) {
            if (gem != null) {
                vitality += gem.getVitality();
            }
        }
        return vitality;
    }

    private int getMinDamage() {
        int minDamage = this.minDamage;
        for (Gem gem : sockets) {
            if (gem != null) {
                minDamage += (2 * gem.getStrength() + 1 * gem.getAgility());
            }
        }
        return minDamage;
    }

    private int getMaxDamage() {
        int maxDamage = this.maxDamage;
        for (Gem gem : sockets) {
            if (gem != null) {
                maxDamage += (3 * gem.getStrength() + 4 * gem.getAgility());
            }
        }
        return maxDamage;
    }

    public double getLevel() {
        return ((this.getMinDamage() + this.getMaxDamage()) / 2.0) +
                this.getStrength() + this.getAgility() + this.getVitality();
    }
}
