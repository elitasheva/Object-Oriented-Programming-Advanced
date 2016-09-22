package logger.factories;

import logger.interfaces.Appender;
import logger.interfaces.Logger;
import logger.interfaces.LoggerFactory;
import logger.models.loggers.LoggerImpl;

public class LoggerFactoryImpl implements LoggerFactory {

    @Override
    public Logger createLogger(Appender... appenders) {
        return new LoggerImpl(appenders);
    }
}
