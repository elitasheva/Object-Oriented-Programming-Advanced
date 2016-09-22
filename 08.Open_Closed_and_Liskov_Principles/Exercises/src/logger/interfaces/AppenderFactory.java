package logger.interfaces;

public interface AppenderFactory {
    Appender createAppender(String type, Layout layout);
}
