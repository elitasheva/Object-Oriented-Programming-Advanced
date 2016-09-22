package blobs.models.blobs;

import blobs.models.behaviors.interfaces.Behavior;

public interface GameObject {

    String getName();

    int getDamage();

    void setDamage(int damage);

    int getHealth();

    void setHealth(int health);

    void attack(GameObject targetBlob);

    boolean hasBehavior();

    Behavior getBehavior();
}
