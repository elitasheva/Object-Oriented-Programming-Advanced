package problem7.factories;

import problem7.interfaces.Observer;
import problem7.interfaces.ObserverCreator;
import problem7.models.Institution;

import java.util.ArrayList;
import java.util.List;

public class ObserverFactory implements ObserverCreator {

    @Override
    public Observer createObserver(String[] params) {
        String id = params[1];
        String name = params[2];
        List<String> subjects = new ArrayList<>();
        for (int i = 3; i < params.length; i++) {
            subjects.add(params[i]);
        }
        return new Institution(id, name, subjects);
    }
}
