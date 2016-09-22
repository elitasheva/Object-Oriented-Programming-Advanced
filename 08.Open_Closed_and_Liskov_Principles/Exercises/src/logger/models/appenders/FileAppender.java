package logger.models.appenders;

import logger.enums.ReportLevel;
import logger.interfaces.LogFile;
import logger.interfaces.Layout;
import logger.models.files.LogFileImpl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileAppender extends AbstractAppender {

    //private static final String FILE_PATH = "src/logger/resources/logs.txt";
    private LogFile logFile;

    public FileAppender(Layout layout) {
        super(layout);
        this.logFile = new LogFileImpl();
    }

    @Override
    public void appenMessage(String message, ReportLevel level, String date) {
        if (level.ordinal() >= super.getReportLevel().ordinal()) {
            super.messageCount++;
            String msg = this.getLayout().formatMessage(message, level, date);
            this.logFile.write(msg);
//            try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(FILE_PATH)))) {
//
//                writer.write(msg + System.lineSeparator());
//
//            } catch (IOException ex) {
//                System.out.println(ex.getMessage());
//            }
        }

    }

    @Override
    public String toString() {
        return "Appender type: " + this.getClass().getSimpleName()
                + super.toString()
                + ", File size: " + this.logFile.getSize();
    }
}
