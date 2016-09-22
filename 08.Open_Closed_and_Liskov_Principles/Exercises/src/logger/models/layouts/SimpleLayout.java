package logger.models.layouts;

import logger.enums.ReportLevel;
import logger.interfaces.Layout;


public class SimpleLayout implements Layout{

    @Override
    public String formatMessage(String message, ReportLevel level, String date) {
        return String.format("%s - %s - %s", date, level, message);
    }
}
