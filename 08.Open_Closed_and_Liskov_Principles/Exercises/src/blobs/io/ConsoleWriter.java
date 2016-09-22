package blobs.io;

import blobs.io.interfaces.Writer;

public class ConsoleWriter implements Writer {

    @Override
    public void writeLine(String message) {
        System.out.println(message);
    }
}
