package problem4.models;

public class StandartEmployee extends EmployeeAbsImpl {

    private static final int DEFAULT_WORK_HOURS_PER_WEEK = 40;

    public StandartEmployee(String name) {
        super(name, DEFAULT_WORK_HOURS_PER_WEEK);
    }
}
