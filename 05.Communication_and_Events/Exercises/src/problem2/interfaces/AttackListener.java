package problem2.interfaces;

import problem2.events.AttackEvent;

public interface AttackListener {

    void respondToAttack(AttackEvent event);
}
