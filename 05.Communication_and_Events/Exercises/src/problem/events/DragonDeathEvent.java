package problem.events;

import problem.models.Item;

import java.util.EventObject;

public class DragonDeathEvent extends EventObject{

    private Item item;

    public DragonDeathEvent(Object source, Item item) {
        super(source);
        this.item = item;
    }

    public Item getItem() {
        return this.item;
    }
}
