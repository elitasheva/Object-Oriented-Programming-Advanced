package blobs.models.attacks;

import blobs.models.attacks.interfaces.Attack;
import blobs.models.blobs.GameObject;

public class Blobplode implements Attack {

    private GameObject blob;

    public void setBlob(GameObject blob) {
        this.blob = blob;
    }

    @Override
    public void produceAttack(GameObject targetBlob) {
        if (this.blob.getHealth() > 1) {
            int damage = this.blob.getDamage() * 2;
            this.blob.setHealth(this.blob.getHealth() - this.blob.getHealth() / 2);
            targetBlob.setHealth(targetBlob.getHealth() - damage);
        }

    }
}
