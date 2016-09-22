package problem7.core;

import problem7.interfaces.Dispatcher;
import problem7.interfaces.Reader;
import problem7.interfaces.Runnable;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

    private Reader reader;
    private Dispatcher dispatcher;

    public Engine(Reader reader, Dispatcher dispatcher) {
        this.reader = reader;
        this.dispatcher = dispatcher;
    }

    @Override
    public void run() throws IOException, InvocationTargetException, IllegalAccessException {
        String[] params = this.reader.readLine().split("[\\s]+");
        int entitiesCount = Integer.parseInt(params[0]);
        int institutionsCount = Integer.parseInt(params[1]);
        int changesCount = Integer.parseInt(params[2]);

        this.dispatcher.readEntities(entitiesCount);
        this.dispatcher.readInstitutions(institutionsCount);

        for (int i = 0; i < changesCount; i++) {
            String[] changesParams = this.reader.readLine().split("[\\s]+");
            this.dispatcher.executeChange(changesParams);
        }

        this.dispatcher.printChangeLog();

    }
}
