package logger;

import logger.controllers.ConstrollerImpl;
import logger.factories.AppenderFactoryImpl;
import logger.factories.LayoutFactoryImpl;
import logger.factories.LoggerFactoryImpl;
import logger.interfaces.AppenderFactory;
import logger.interfaces.Controller;
import logger.interfaces.LayoutFactory;
import logger.interfaces.LoggerFactory;


public class Main {

    public static void main(String[] args) {

        AppenderFactory appenderFactory = new AppenderFactoryImpl();
        LayoutFactory layoutFactory = new LayoutFactoryImpl();
        LoggerFactory loggerFactory = new LoggerFactoryImpl();

        Controller controller = new ConstrollerImpl(appenderFactory, layoutFactory, loggerFactory);
        controller.handleInput();
    }
}
