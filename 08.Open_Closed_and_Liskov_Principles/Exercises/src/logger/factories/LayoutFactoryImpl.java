package logger.factories;

import logger.interfaces.Layout;
import logger.interfaces.LayoutFactory;
import logger.models.layouts.SimpleLayout;
import logger.models.layouts.XmlLayout;

public class LayoutFactoryImpl implements LayoutFactory {

    @Override
    public Layout createLayout(String type) {
        switch (type) {
            case "SimpleLayout":
                return new SimpleLayout();
            case "XmlLayout":
                return new XmlLayout();
            default:
                throw new IllegalArgumentException("Unsupported layout type.");

        }
    }
}
