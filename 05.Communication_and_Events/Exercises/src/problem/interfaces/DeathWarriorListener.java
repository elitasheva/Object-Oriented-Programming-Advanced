package problem.interfaces;

import problem.events.WarriorDeathEvenet;

public interface DeathWarriorListener {

    void handleWithTheDeadWarrior(WarriorDeathEvenet evenet);
}
