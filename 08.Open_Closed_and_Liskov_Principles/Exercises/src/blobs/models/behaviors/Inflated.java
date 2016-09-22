package blobs.models.behaviors;

import blobs.models.behaviors.interfaces.Behavior;
import blobs.models.blobs.GameObject;

public class Inflated implements Behavior {

    private static final int ADDITION_HEALTH = 50;
    private static final int HEALTH_TO_LOSE = 10;
    private boolean firstTime = true;
    private GameObject blob;

    @Override
    public void setBlob(GameObject blob) {
        this.blob = blob;
    }

    @Override
    public void triggerBehavior() {
        blob.setHealth(blob.getHealth() + ADDITION_HEALTH);
    }

    @Override
    public void executeBehavior() {
        if (firstTime){
            firstTime = false;
        }else {
            this.blob.setHealth(this.blob.getHealth() - HEALTH_TO_LOSE);
        }
    }
}
