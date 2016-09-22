package problem.interfaces;

import problem.events.DragonDeathEvent;

public interface DragonDeathListener {

    void handleWithTheDeadDragon(DragonDeathEvent event);
}
