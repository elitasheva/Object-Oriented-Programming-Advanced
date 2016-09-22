package blobs.models.attacks.interfaces;

import blobs.models.blobs.GameObject;

public interface Attack {

    void produceAttack(GameObject targetBlob);

    void setBlob(GameObject blob);
}
