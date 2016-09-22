package logger.factories;

import logger.interfaces.Appender;
import logger.interfaces.AppenderFactory;
import logger.interfaces.Layout;
import logger.models.appenders.ConsoleAppender;
import logger.models.appenders.FileAppender;


public class AppenderFactoryImpl implements AppenderFactory {

    @Override
    public Appender createAppender(String type, Layout layout) {
        switch (type) {
            case "ConsoleAppender":
                return new ConsoleAppender(layout);
            case "FileAppender":
                return new FileAppender(layout);
            default:
                throw new IllegalArgumentException("Unsupported appender type.");
        }
    }
}
