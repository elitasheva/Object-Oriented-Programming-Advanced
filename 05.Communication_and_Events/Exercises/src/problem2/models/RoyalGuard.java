package problem2.models;

import problem2.events.AttackEvent;
import problem2.interfaces.AttackListener;

public class RoyalGuard extends Unit implements AttackListener {

    private static final int DEFAULT_LIVES = 3;

    public RoyalGuard(String name) {
        super(name, DEFAULT_LIVES);
    }

    @Override
    public void respondToAttack(AttackEvent event) {
        System.out.println(String.format("Royal Guard %s is defending!", this.getName()));
    }
}
