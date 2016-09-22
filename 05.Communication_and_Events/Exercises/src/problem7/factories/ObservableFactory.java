package problem7.factories;

import problem7.interfaces.Observable;
import problem7.interfaces.ObservableCreator;
import problem7.models.Company;
import problem7.models.Employee;
import problem7.models.Entity;

public class ObservableFactory implements ObservableCreator {
    @Override
    public Observable createObservable(String[] params) {
        String type = params[0];
        String id = params[1];
        String name = params[2];

        switch (type){
            case "Employee":
                int income = Integer.parseInt(params[3]);
                return new Employee(id, name, income);
            case "Company":
                int turnover = Integer.parseInt(params[3]);
                int revenue = Integer.parseInt(params[4]);
                return new Company(id, name, turnover, revenue);
            default:
                throw new IllegalArgumentException("Invalid arguments.");
        }

    }
}
