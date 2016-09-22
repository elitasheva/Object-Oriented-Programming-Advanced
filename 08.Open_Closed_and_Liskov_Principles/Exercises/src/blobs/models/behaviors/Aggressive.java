package blobs.models.behaviors;

import blobs.models.behaviors.interfaces.Behavior;
import blobs.models.blobs.GameObject;

public class Aggressive implements Behavior {

    private static final int DAMAGE_TO_LOSE = 5;
    private GameObject blob;
    private boolean firstTime = true;

    public void setBlob(GameObject blob) {
        this.blob = blob;
    }

    @Override
    public void triggerBehavior() {
        this.blob.setDamage(blob.getDamage() * 2);
    }

    @Override
    public void executeBehavior() {
        if (firstTime){
            firstTime = false;
        }else {
            this.blob.setDamage(this.blob.getDamage() - DAMAGE_TO_LOSE);
        }
    }
}
