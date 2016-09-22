package logger.interfaces;

import logger.enums.ReportLevel;

import java.time.ZonedDateTime;

public interface Appender {
    void appenMessage(String message, ReportLevel level, String date);
    void setReportLevel(ReportLevel reportLevel);
}
