package problem7.interfaces;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public interface Dispatcher {
    void readEntities(int count) throws IOException;
    void readInstitutions(int count) throws IOException;
    void executeChange(String[] changeParams) throws InvocationTargetException, IllegalAccessException;
    void printChangeLog();
}
