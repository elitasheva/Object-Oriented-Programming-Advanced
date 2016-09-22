package blobs.models.behaviors.interfaces;

import blobs.models.blobs.GameObject;

public interface Behavior {

    void setBlob(GameObject blob);

    void triggerBehavior();

    void executeBehavior();
}
