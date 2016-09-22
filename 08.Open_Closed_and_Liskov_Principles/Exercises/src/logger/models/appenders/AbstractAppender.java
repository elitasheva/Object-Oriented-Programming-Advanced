package logger.models.appenders;

import logger.enums.ReportLevel;
import logger.interfaces.Appender;
import logger.interfaces.Layout;

public abstract class AbstractAppender implements Appender {

    private static final ReportLevel DEFAULT_REPORT_LEVEL_THRESHOLD = ReportLevel.INFO;

    private Layout layout;
    private ReportLevel reportLevel;
    protected int messageCount;

    protected AbstractAppender(Layout layout) {
        this.layout = layout;
        this.reportLevel = DEFAULT_REPORT_LEVEL_THRESHOLD;
    }

    protected Layout getLayout() {
        return this.layout;
    }

    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    public ReportLevel getReportLevel() {
        return this.reportLevel;
    }

    @Override
    public String toString() {
        return ", Layout type: " + this.layout.getClass().getSimpleName()
                + ", Report level: " + this.reportLevel.name()
                + ", Messages appended: " + this.messageCount;
    }

}
