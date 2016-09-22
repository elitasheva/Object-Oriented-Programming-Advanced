package problem10;

import problem10.core.Database;
import problem10.core.Engine;
import problem10.io.CommandDispatcher;
import problem10.io.InputReader;
import problem10.io.OutputWriter;

public class Main {

    public static void main(String[] args) {
        InputReader reader = new InputReader();
        OutputWriter writer = new OutputWriter();
        Database database = new Database();
        CommandDispatcher dispatcher = new CommandDispatcher(database, writer);
        Engine engine = new Engine(reader, dispatcher);
        engine.run();
    }
}

