package problem7.core;

import problem7.annotations.Setter;
import problem7.interfaces.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class CommandDispatcher implements Dispatcher {

    private Reader reader;
    private Writer writer;
    private ObservableCreator observableCreator;
    private ObserverCreator observerCreator;
    private Data database;

    public CommandDispatcher(Reader reader, Writer writer, ObservableCreator observableCreator, ObserverCreator observerCreator, Data database) {
        this.reader = reader;
        this.writer = writer;
        this.observableCreator = observableCreator;
        this.observerCreator = observerCreator;
        this.database = database;
    }

    @Override
    public void readEntities(int count) throws IOException {
        for (int i = 0; i < count; i++) {
            String[] params = this.reader.readLine().split("[\\s]+");
            Observable currentObservable = this.observableCreator.createObservable(params);
            this.database.addOservable(currentObservable);
        }
    }

    @Override
    public void readInstitutions(int count) throws IOException {
        for (int i = 0; i < count; i++) {
            String[] params = this.reader.readLine().split("[\\s]+");
            Observer currentObserver = this.observerCreator.createObserver(params);
            this.database.addObserver(currentObserver);
            this.database.subscribeObserver(currentObserver);

        }
    }

    @Override
    public void executeChange(String[] changeParams) throws InvocationTargetException, IllegalAccessException {
        String id = changeParams[0];
        String fieldName = changeParams[1];
        String parameter = changeParams[2];

        Observable observable = this.database.getObservable(id);

        Class<?> observableClass = observable.getClass();
        Method[] methods = observableClass.getDeclaredMethods();

        for (Method method : methods) {
            Setter setter = method.getAnnotation(Setter.class);
            if (setter != null && setter.fieldName().equals(fieldName)){
                if (setter.fieldType().equals("int")){
                    method.invoke(observable, Integer.parseInt(parameter));
                }else {
                    method.invoke(observable, parameter);
                }
            }
        }

    }

    @Override
    public void printChangeLog() {
        for (String observerId : this.database.getObservers()) {
            Observer observer = this.database.getObserver(observerId);
            List<String> observerChangeLog = observer.getFileLog();

            String heading = String.format("%s: %s changes registered", observer.getName(), observerChangeLog.size());
            this.writer.writeLine(heading);

            for (String change : observerChangeLog) {
                this.writer.writeLine(change);
            }
        }

    }
}
