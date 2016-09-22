package logger.controllers;

import logger.enums.ReportLevel;
import logger.interfaces.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConstrollerImpl implements Controller {

    private AppenderFactory appenderFactory;
    private LayoutFactory layoutFactory;
    private LoggerFactory loggerFactory;

    public ConstrollerImpl(AppenderFactory appenderFactory, LayoutFactory layoutFactory, LoggerFactory loggerFactory) {
        this.appenderFactory = appenderFactory;
        this.layoutFactory = layoutFactory;
        this.loggerFactory = loggerFactory;
    }

    @Override
    public void handleInput() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int countAppenders = Integer.parseInt(reader.readLine());
            Appender[] appenders = new Appender[countAppenders];
            for (int i = 0; i < countAppenders; i++) {
                String[] inputParams = reader.readLine().split("[\\s]+");
                String appenderType = inputParams[0];
                String layoutType = inputParams[1];
                Layout currentLayout = this.layoutFactory.createLayout(layoutType);
                Appender currentAppender = this.appenderFactory.createAppender(appenderType, currentLayout);
                if (inputParams.length == 3){
                    ReportLevel reportLevel = ReportLevel.valueOf(inputParams[2]);
                    currentAppender.setReportLevel(reportLevel);
                }
                appenders[i] = currentAppender;

            }

            Logger logger = this.loggerFactory.createLogger(appenders);

            while (true) {

                String msg = reader.readLine();
                if ("END".equals(msg)){
                    break;
                }

                String[] msgParams = msg.split("[|]");
                ReportLevel reportLevel = ReportLevel.valueOf(msgParams[0]);
                String date = msgParams[1];
                String message = msgParams[2];

                switch (reportLevel){
                    case INFO:
                        logger.logInfo(message,date);
                        break;
                    case WARNING:
                        logger.logWarning(message,date);
                        break;
                    case ERROR:
                        logger.logError(message,date);
                        break;
                    case CRITICAL:
                        logger.logCritical(message,date);
                        break;
                    case FATAL:
                        logger.logFatal(message,date);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown report level.");
                }

            }
            System.out.println(logger.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
