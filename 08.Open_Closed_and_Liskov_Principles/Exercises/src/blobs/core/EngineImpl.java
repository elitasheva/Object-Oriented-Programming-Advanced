package blobs.core;

import blobs.core.interfaces.CommandInterpretator;
import blobs.core.interfaces.Engine;
import blobs.io.interfaces.Reader;
import java.io.IOException;

public class EngineImpl implements Engine {

    private Reader reader;
    private CommandInterpretator commandInterpretator;

    public EngineImpl(Reader reader, CommandInterpretator commandInterpretator) {
        this.reader = reader;
        this.commandInterpretator = commandInterpretator;
    }

    @Override
    public void run() {

        while (true) {

            try {
                String input = this.reader.readLine();
                if ("drop".equals(input)){
                    break;
                }

                String[] params = input.split("[\\s]+");
                this.commandInterpretator.interpredCommand(params);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
