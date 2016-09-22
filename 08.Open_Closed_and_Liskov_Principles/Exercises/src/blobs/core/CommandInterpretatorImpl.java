package blobs.core;

import blobs.core.interfaces.CommandInterpretator;
import blobs.factories.Factory;
import blobs.models.attacks.interfaces.Attack;
import blobs.models.behaviors.interfaces.Behavior;
import blobs.models.blobs.GameObject;
import blobs.io.interfaces.Writer;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class CommandInterpretatorImpl implements CommandInterpretator {

    private Factory factory;
    private Writer writer;
    private HashMap<String, GameObject> blobsByName;

    public CommandInterpretatorImpl(Factory factory, Writer writer) {
        this.factory = factory;
        this.writer = writer;
        this.blobsByName = new LinkedHashMap<>();
    }

    @Override
    public void interpredCommand(String[] params) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        String command = params[0];
        switch (command) {
            case "create":
                executeCreateCommand(params);
                break;
            case "attack":
                executeAttackCommand(params);
                break;
            case "pass":
                break;
            case "status":
                executeStatusCommand();
                break;
            default:
                throw new IllegalArgumentException("Unknown command.");
        }

        Collection<GameObject> gameObjects = new ArrayList<>(this.blobsByName.values());
        for (GameObject gameObject : gameObjects) {
            if (gameObject.hasBehavior()) {
                gameObject.getBehavior().executeBehavior();
                checkIsDead(gameObject);
            }
        }

    }

    private void executeStatusCommand() {
        for (GameObject gameObject : blobsByName.values()) {
            this.writer.writeLine(gameObject.toString());
        }
    }

    private void executeAttackCommand(String[] params) {
        String attackerName = params[1];
        String targetName = params[2];
        GameObject attacker = this.blobsByName.get(attackerName);
        GameObject target = this.blobsByName.get(targetName);
        attacker.attack(target);
        checkIsDead(target);
    }

    private void checkIsDead(GameObject blob) {
        if (blob.getHealth() <= 0) {
            this.writer.writeLine(String.format("Blob %s KILLED", blob.getName()));
            this.blobsByName.remove(blob.getName());
        }
    }

    private void executeCreateCommand(String[] params) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String name = params[1];
        int health = Integer.parseInt(params[2]);
        int damage = Integer.parseInt(params[3]);
        String behaviorType = params[4];
        String attackType = params[5];
        Behavior behavior = this.factory.createBehavior(behaviorType);
        Attack attack = this.factory.createAttack(attackType);
        GameObject blob = this.factory.createBlob(name, health, damage, behavior, attack);
        behavior.setBlob(blob);
        attack.setBlob(blob);
        this.blobsByName.put(name, blob);

    }
}
