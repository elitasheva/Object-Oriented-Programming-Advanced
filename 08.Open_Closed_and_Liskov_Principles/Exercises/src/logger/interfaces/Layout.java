package logger.interfaces;

import logger.enums.ReportLevel;


public interface Layout {
        String formatMessage(String message, ReportLevel level, String date);
}
