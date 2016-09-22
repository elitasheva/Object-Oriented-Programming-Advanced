package logger.interfaces;

public interface LoggerFactory {
    Logger createLogger(Appender... appenders);
}
