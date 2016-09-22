package logger.models.appenders;

import logger.enums.ReportLevel;
import logger.interfaces.Layout;


public class ConsoleAppender extends AbstractAppender {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void appenMessage(String message, ReportLevel level, String date) {
        if (level.ordinal() >= super.getReportLevel().ordinal()) {
            super.messageCount++;
            String msg = this.getLayout().formatMessage(message, level, date);
            System.out.println(msg);
        }
    }

    @Override
    public String toString() {
        return "Appender type: " + this.getClass().getSimpleName()
                + super.toString();
    }
}
