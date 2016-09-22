package logger.models.layouts;

import logger.enums.ReportLevel;
import logger.interfaces.Layout;


public class XmlLayout implements Layout {

    @Override
    public String formatMessage(String message, ReportLevel level, String date) {
        StringBuilder sb = new StringBuilder();
        sb.append("<log>").append(System.lineSeparator());
        sb.append(String.format("   <date>%s</date>", date)).append(System.lineSeparator());
        sb.append(String.format("   <level>%s</level>", level)).append(System.lineSeparator());
        sb.append(String.format("   <message>%s</message>", message)).append(System.lineSeparator());
        sb.append("</log>");

        return sb.toString();

    }
}
