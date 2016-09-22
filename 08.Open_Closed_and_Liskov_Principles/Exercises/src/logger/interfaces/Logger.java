package logger.interfaces;

import java.time.ZonedDateTime;

public interface Logger {
    void logError(String message, String date);

    void logInfo(String message, String date);

    void logWarning(String message, String date);

    void logCritical(String message, String date);

    void logFatal(String message, String date);
}
