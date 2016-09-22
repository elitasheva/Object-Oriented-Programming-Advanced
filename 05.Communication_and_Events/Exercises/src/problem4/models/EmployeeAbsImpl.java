package problem4.models;

import problem4.interfaces.Employee;

public abstract class EmployeeAbsImpl implements Employee {
    private String name;
    private int workHoursPerWeek;

    public EmployeeAbsImpl(String name, int workHoursPerWeek) {
        this.name = name;
        this.workHoursPerWeek = workHoursPerWeek;
    }

    public String getName() {
        return this.name;
    }

    public int getWorkHoursPerWeek() {
        return this.workHoursPerWeek;
    }
}
