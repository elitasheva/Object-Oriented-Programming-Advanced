package problem7.models;

import problem7.interfaces.Event;
import problem7.interfaces.Observable;
import problem7.interfaces.Observer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Institution implements Observer {

    private String id;
    private String name;
    private List<String> subjects;
    private List<String> logFile;

    public Institution(String id, String name, List<String> subjects) {
        this.id = id;
        this.name = name;
        this.subjects = subjects;
        this.logFile = new ArrayList<>();
    }


    @Override
    public void update(Event event) {

        Observable source = event.getSource();
        String sourceClass = source.getClass().getSimpleName();
        String id = source.getId();
        Field changedField = event.getChangedField();

        String fieldName = changedField.getName();
        String fieldType = changedField.getType().getSimpleName();

        String oldValue = event.getOldValue().toString();
        String newValue = event.getNewValue().toString();

        if (subjects.contains(fieldName)) {
            String result =
                    String.format("--%s(ID:%s) changed %s(%s) from %s to %s",
                            sourceClass,
                            id,
                            fieldName,
                            fieldType,
                            oldValue,
                            newValue);

            logFile.add(result);
        }
    }

    @Override
    public List<String> getFileLog() {
        return this.logFile;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
