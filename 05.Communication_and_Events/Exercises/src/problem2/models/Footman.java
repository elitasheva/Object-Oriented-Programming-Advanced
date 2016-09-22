package problem2.models;

import problem2.events.AttackEvent;
import problem2.interfaces.AttackListener;

public class Footman extends Unit implements AttackListener{

    private static final int DEFAULT_LIVES = 2;

    public Footman(String name) {
        super(name, DEFAULT_LIVES);
    }

    @Override
    public void respondToAttack(AttackEvent event) {
        System.out.println(String.format("Footman %s is panicking!", this.getName()));
    }
}
