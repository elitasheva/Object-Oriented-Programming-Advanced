package logger.models.loggers;

import logger.enums.ReportLevel;
import logger.interfaces.Appender;
import logger.interfaces.Logger;


public class LoggerImpl implements Logger{

    private Appender[] appenders;

    public LoggerImpl(Appender... appenders) {
        this.appenders = appenders;
    }

    public void logError(String message, String date) {
        this.append(message, ReportLevel.ERROR, date);
    }

    public void logInfo(String message, String date) {
        this.append(message, ReportLevel.INFO, date);
    }

    public void logWarning(String message, String date) {
        this.append(message, ReportLevel.WARNING, date);
    }

    public void logCritical(String message, String date) {
        this.append(message, ReportLevel.CRITICAL, date);
    }

    public void logFatal(String message, String date) {
        this.append(message, ReportLevel.FATAL, date);
    }

    private void append(String message, ReportLevel level, String date) {
        for (Appender appender : appenders) {
            appender.appenMessage(message, level, date);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Logger info").append(System.lineSeparator());
        for (Appender appender : appenders) {
            result.append(appender).append(System.lineSeparator());
        }

        return result.toString();
    }
}
