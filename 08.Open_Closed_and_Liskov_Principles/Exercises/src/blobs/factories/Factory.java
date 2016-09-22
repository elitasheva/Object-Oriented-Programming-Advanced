package blobs.factories;

import blobs.models.attacks.interfaces.Attack;
import blobs.models.behaviors.interfaces.Behavior;
import blobs.models.blobs.GameObject;

import java.lang.reflect.InvocationTargetException;

public interface Factory {

    Attack createAttack(String type) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;

    Behavior createBehavior(String type) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;

    GameObject createBlob(String name, int health, int damage, Behavior behavior, Attack attack);
}
