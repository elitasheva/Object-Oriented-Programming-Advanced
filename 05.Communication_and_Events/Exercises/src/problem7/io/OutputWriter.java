package problem7.io;

import problem7.interfaces.Writer;

public class OutputWriter implements Writer {

    @Override
    public void writeLine(String message) {
        System.out.println(message);
    }
}
