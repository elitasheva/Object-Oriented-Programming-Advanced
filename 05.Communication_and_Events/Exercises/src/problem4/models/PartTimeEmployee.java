package problem4.models;

public class PartTimeEmployee extends EmployeeAbsImpl {

    private static final int DEFAULT_WORK_HOURS_PER_WEEK = 20;

    public PartTimeEmployee(String name) {
        super(name, DEFAULT_WORK_HOURS_PER_WEEK);
    }
}
