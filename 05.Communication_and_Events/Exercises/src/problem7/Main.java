package problem7;


import problem7.core.CommandDispatcher;
import problem7.core.Database;
import problem7.core.Engine;
import problem7.factories.ObservableFactory;
import problem7.factories.ObserverFactory;
import problem7.interfaces.*;
import problem7.interfaces.Runnable;
import problem7.io.InputReader;
import problem7.io.OutputWriter;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) {
        Data database = new Database();
        Reader reader = new InputReader();
        Writer writer = new OutputWriter();
        ObserverCreator observerCreator = new ObserverFactory();
        ObservableCreator observableCreator = new ObservableFactory();
        Dispatcher dispatcher = new CommandDispatcher(reader, writer, observableCreator, observerCreator, database);
        Runnable engine = new Engine(reader, dispatcher);

        try {
            engine.run();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
