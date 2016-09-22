package problem10.core;

import problem10.io.CommandDispatcher;
import problem10.io.InputReader;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Engine {

    private InputReader reader;
    private CommandDispatcher dispatcher;

    public Engine(InputReader reader, CommandDispatcher dispatcher) {
        this.reader = reader;
        this.dispatcher = dispatcher;
    }

    public void run() {

        while (true) {


            try {
                String input = reader.readLine();
                if ("END".equals(input)) {
                    break;
                }

                String[] tokens = input.split(";");
                dispatcher.dispatchCommand(tokens);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
