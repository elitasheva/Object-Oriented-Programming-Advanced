package main.bg.softuni.exceptions;

public class InvalidCommandException extends RuntimeException {

    private static final String INVALID_COMMAND_MESSAGE = "The command '%s' is invalid";

    public InvalidCommandException(String input) {
        super(String.format(INVALID_COMMAND_MESSAGE,input));
    }
}
