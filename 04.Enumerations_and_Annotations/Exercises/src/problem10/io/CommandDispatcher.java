package problem10.io;

import problem10.annotations.CustomAnnotation;
import problem10.core.Database;
import problem10.enums.Gem;
import problem10.enums.TypeOfWeapon;
import problem10.models.Weapon;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class CommandDispatcher {

    private OutputWriter writer;
    private Database database;

    public CommandDispatcher(Database database, OutputWriter writer) {
        this.database = database;
        this.writer = writer;
    }

    public void dispatchCommand(String[] tokens) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String command = tokens[0];
        switch (command) {
            case "Create":
                executeCreateCommand(tokens);
                break;
            case "Add":
                executeAddCommand(tokens);
                break;
            case "Remove":
                executeRemoveCommand(tokens);
                break;
            case "Print":
                executePrintCommand(tokens[1]);
                break;
            case "Compare":
                executeCompareCommand(tokens);
                break;
            case "Author":
            case "Revision":
            case "Description":
            case "Reviewers":
                executeAnnotationsCommand(tokens);
                break;
            default:
                this.writer.writeLine("Invalid command!");
        }

    }

    private void executeAnnotationsCommand(String[] tokens) {
        Class<Weapon> weapon = Weapon.class;
        CustomAnnotation customAnnotation = weapon.getAnnotation(CustomAnnotation.class);
        switch (tokens[0]) {
            case "Author":
                this.writer.writeLine("Author: " + customAnnotation.author());
                break;
            case "Revision":
                this.writer.writeLine("Revision: " + customAnnotation.revision());
                break;
            case "Description":
                this.writer.writeLine("Class description: " + customAnnotation.description());
                break;
            case "Reviewers":
                String reviewers = String.join(", ", Arrays.asList(customAnnotation.reviewers()));
                this.writer.writeLine("Reviewers: " + reviewers);
                break;

        }
    }

    private void executeCompareCommand(String[] tokens) {
        String firstWeaponName = tokens[1];
        String seconWeaponName = tokens[2];
        Weapon firstWeapon = this.database.getWeaponByName(firstWeaponName);
        Weapon secondWeapon = this.database.getWeaponByName(seconWeaponName);
        Weapon bigger = null;
        if (firstWeapon.compareTo(secondWeapon) >= 0) {
            bigger = firstWeapon;
        } else {
            bigger = secondWeapon;
        }
        this.writer.writeLine(bigger.toString() + String.format(" (Item Level: %.1f)", bigger.getLevel()));
    }

    private void executePrintCommand(String token) {
        String weaponName = token;
        Weapon currentWeapon = this.database.getWeaponByName(weaponName);
        this.writer.writeLine(currentWeapon.toString());
    }

    private void executeRemoveCommand(String[] tokens) {
        String weaponName = tokens[1];
        int index = Integer.parseInt(tokens[2]);
        Weapon currentWeapon = this.database.getWeaponByName(weaponName);
        currentWeapon.removeGem(index);
    }

    private void executeAddCommand(String[] tokens) {
        String weaponeName = tokens[1];
        int index = Integer.parseInt(tokens[2]);
        String typeOfGem = tokens[3];
        Weapon currentWeapon = this.database.getWeaponByName(weaponeName);
        Gem currentGem = Gem.valueOf(typeOfGem);
        currentWeapon.addGem(currentGem, index);
    }

    private void executeCreateCommand(String[] tokens) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        String typeInput = tokens[1];
        String type = TypeOfWeapon.valueOf(typeInput).getType();
        String nameOfWeapon = tokens[2];
        String path = Weapon.class.getPackage().getName();
        Class current = Class.forName(path + "." + type);
        Constructor<?> constr = current.getConstructor(String.class);
        Weapon currentWeapon = (Weapon) constr.newInstance(nameOfWeapon);
        this.database.addWeapon(nameOfWeapon, currentWeapon);
    }
}
