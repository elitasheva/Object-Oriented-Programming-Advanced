package blobs.models.attacks;

import blobs.models.attacks.interfaces.Attack;
import blobs.models.blobs.GameObject;

public class PutridFart implements Attack {

    private GameObject blob;

    public void setBlob(GameObject blob) {
        this.blob = blob;
    }

    @Override
    public void produceAttack(GameObject targetBlob) {
        int damage = this.blob.getDamage();
        targetBlob.setHealth(targetBlob.getHealth() - damage);
    }
}
