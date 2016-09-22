package problem6.io;

import problem6.interfaces.Writer;

public class OutputWriter implements Writer {
    @Override
    public void writeLine(String message) {
        System.out.println(message);
    }
}
