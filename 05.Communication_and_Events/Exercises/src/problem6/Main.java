package problem6;

import problem6.core.CommandExecutor;
import problem6.core.Engine;
import problem6.interfaces.Executable;
import problem6.interfaces.Reader;
import problem6.interfaces.Runnable;
import problem6.interfaces.Writer;
import problem6.io.InputReader;
import problem6.io.OutputWriter;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Reader reader = new InputReader();
        Writer writer = new OutputWriter();
        Executable executor = new CommandExecutor(writer);
        Runnable engine = new Engine(reader, executor);
        try {
            engine.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
