package problem.models;

import problem.events.DragonDeathEvent;
import problem.events.WarriorDeathEvenet;
import problem.interfaces.DeathWarriorListener;
import problem.interfaces.DragonDeathListener;

import java.util.Collections;
import java.util.List;

public class Battlefield implements DeathWarriorListener, DragonDeathListener {

    private List<Warrior> warriors;
    private Dragon dragon;
    private Warrior mainWarrior;


    public Battlefield(Dragon dragon, List<Warrior> warriors) {
        this.dragon = dragon;
        this.warriors = warriors;
        this.setMainWarrior();
        this.addListenersToDragon();

    }

    public void applyFight() {
        int count = 0;
        int dragonAttackCount = 0;

        while (this.dragon != null && this.warriors.size() > 0) {
            if (count % 2 == 0) {
                dragonAttackCount++;
                if (dragonAttackCount % 3 == 0) {
                    //dragon attack all warriors
                    for (int i = this.warriors.size() - 1; i >= 0; i--) {
                        Warrior currentWarrior = this.warriors.get(i);
                        currentWarrior.respondToAttack(this.dragon);
                    }
                }
                //dragon attack most expirienced warrior
                this.mainWarrior.respondToAttack(dragon);
            } else {
                //warrior attack dragon
                for (int i = this.warriors.size() - 1; i >= 0; i--) {
                    Warrior currentWarrior = this.warriors.get(i);
                    this.dragon.respondToAttack(currentWarrior);
                }
            }
            count++;

        }
        if (this.dragon == null) {
            for (int i = this.warriors.size() - 1; i >= 0; i--) {
                Warrior cuurentWarrior = this.warriors.get(i);
                System.out.println(cuurentWarrior.toString());
            }
        }

        if (this.warriors.size() == 0) {
            System.out.println(String.format("%s %d", this.dragon.getName(), this.dragon.getHealthPoints()));
        }

    }

    private void addListenersToDragon() {
        for (int i = this.warriors.size() - 1; i >= 0; i--) {
            Warrior currentWarrior = this.warriors.get(i);
            currentWarrior.addDeathWarriorListeners(this);
            this.dragon.addDragonDeathListener(currentWarrior);
        }
    }

    @Override
    public void handleWithTheDeadWarrior(WarriorDeathEvenet evenet) {
        //TODO avoid this cast
        Warrior deadWarrior = (Warrior) evenet.getSource();
        this.warriors.remove(deadWarrior);
        if (deadWarrior == this.mainWarrior) {
            setMainWarrior();
        }

    }

    @Override
    public void handleWithTheDeadDragon(DragonDeathEvent event) {
        this.dragon = null;
    }

    private void setMainWarrior() {
        if (this.warriors.size() > 0) {
            Collections.sort(warriors);
            this.mainWarrior = this.warriors.get(this.warriors.size() - 1);
            for (Warrior warrior : warriors) {
                if (warrior != this.mainWarrior) {
                    warrior.setAura(this.mainWarrior.getExperience());
                }
            }
        }
    }
}
