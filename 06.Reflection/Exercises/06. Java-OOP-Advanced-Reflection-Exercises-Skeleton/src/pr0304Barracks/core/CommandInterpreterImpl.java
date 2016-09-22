package pr0304Barracks.core;

import pr0304Barracks.annotations.Inject;
import pr0304Barracks.contracts.CommandInterpreter;
import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;
import pr0304Barracks.core.commands.Command;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class CommandInterpreterImpl implements CommandInterpreter {

    private static final String COMMAND_PACKAGE_NAME =
            "pr0304Barracks.core.commands.";
    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {

        String command = commandName.substring(0, 1).toUpperCase() + commandName.substring(1);

        Executable currentCommand = null;
        try {
            Class<Command> commandClass = (Class<Command>) Class.forName(COMMAND_PACKAGE_NAME + command + "Command");
            Constructor commandConstructor = commandClass.getDeclaredConstructor(String[].class);
            currentCommand = (Command) commandConstructor.newInstance((Object) data);
            this.injectDependencies(currentCommand, commandClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return currentCommand;
    }

    private void injectDependencies(Executable commandInstance, Class<Command> commandClass) throws IllegalAccessException {

        Field[] cmdFields = commandClass.getDeclaredFields();
        Field[] theseFields = CommandInterpreterImpl.class.getDeclaredFields();

        for (Field field : cmdFields) {
            if (!field.isAnnotationPresent(Inject.class)) {
                continue;
            }
            field.setAccessible(true);

            for (Field thisField : theseFields) {
                if (!thisField.getType().equals(field.getType())) {
                    continue;
                }
                thisField.setAccessible(true);
                field.set(commandInstance, thisField.get(this));
            }
        }
    }
}
