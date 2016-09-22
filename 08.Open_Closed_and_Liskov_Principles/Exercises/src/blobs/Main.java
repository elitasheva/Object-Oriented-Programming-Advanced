package blobs;

import blobs.core.CommandInterpretatorImpl;
import blobs.core.EngineImpl;
import blobs.core.interfaces.CommandInterpretator;
import blobs.core.interfaces.Engine;
import blobs.factories.Factory;
import blobs.factories.FactoryImpl;
import blobs.io.ConsoleReader;
import blobs.io.ConsoleWriter;
import blobs.io.interfaces.Reader;
import blobs.io.interfaces.Writer;

public class Main {

    public static void main(String[] args) {

        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        Factory factory = new FactoryImpl();
        CommandInterpretator commandInterpretator = new CommandInterpretatorImpl(factory, writer);
        Engine engine = new EngineImpl(reader, commandInterpretator);
        engine.run();

    }
}
