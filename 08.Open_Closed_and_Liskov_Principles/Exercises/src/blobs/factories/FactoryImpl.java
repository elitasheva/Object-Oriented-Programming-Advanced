package blobs.factories;

import blobs.models.attacks.interfaces.Attack;
import blobs.models.behaviors.interfaces.Behavior;
import blobs.models.blobs.GameObject;
import blobs.models.blobs.Blob;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class FactoryImpl implements Factory {

    private static final String ATTACK_PACKAGE_PATH = "blobs.models.attacks";
    private static final String BEHAVIOR_PACKAGE_PATH = "blobs.models.behaviors";

    @Override
    public Attack createAttack(String type) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName(ATTACK_PACKAGE_PATH + "." + type);
        Constructor<?> constructor = clazz.getConstructor();
        Attack attack = (Attack) constructor.newInstance();
        return attack;
    }

    @Override
    public Behavior createBehavior(String type) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName(BEHAVIOR_PACKAGE_PATH + "." + type);
        Constructor<?> constructor = clazz.getConstructor();
        Behavior behavior = (Behavior) constructor.newInstance();
        return behavior;
    }

    @Override
    public GameObject createBlob(String name, int health, int damage, Behavior behavior, Attack attack) {
        return new Blob(name, health, damage, behavior, attack);
    }
}
