package blobs.core.interfaces;

import java.lang.reflect.InvocationTargetException;

public interface CommandInterpretator {
    void interpredCommand(String[] params) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException;
}
