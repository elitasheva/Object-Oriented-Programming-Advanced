package problem7.interfaces;

import java.util.List;

public interface Observer extends Identifiable, Nameable{
    void update(Event event);
    List<String> getFileLog();

}
