package problem4.models;

import problem4.events.DoneJobEvent;
import problem4.interfaces.DoneJobListener;
import problem4.interfaces.Employee;

import java.util.ArrayList;
import java.util.List;

public class Job {

    private String name;
    private int hoursOfWorkRequired;
    private Employee employee;
    private List<DoneJobListener> observers;

    public Job(String name, int hoursOfWorkRequired, Employee employee) {
        this.setName(name);
        this.setHoursOfWorkRequired(hoursOfWorkRequired);
        this.setEmployee(employee);
        this.observers = new ArrayList<>();
    }

    public int getHoursOfWorkRequired() {
        return this.hoursOfWorkRequired;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setHoursOfWorkRequired(int hoursOfWorkRequired) {
        this.hoursOfWorkRequired = hoursOfWorkRequired;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    private void setEmployee(Employee employee) {
        this.employee = employee;
    }


    public void update() {
        this.setHoursOfWorkRequired(this.hoursOfWorkRequired - this.employee.getWorkHoursPerWeek());
        if (this.getHoursOfWorkRequired() <= 0) {
            System.out.println(String.format("Job %s done!", this.getName()));
            fireEvent();
        }

    }

    public void addJobCompletedListener(DoneJobListener listener) {
        this.observers.add(listener);
    }

    public void removeJobCompletedListener(DoneJobListener listener) {
        this.observers.remove(listener);
    }

    private void fireEvent() {
        DoneJobEvent event = new DoneJobEvent(this);
        for (DoneJobListener observer : observers) {
            observer.handleEvent(event);
        }
    }

    @Override
    public String toString() {
        return String.format("Job: %s Hours Remaining: %d", this.getName(), this.getHoursOfWorkRequired());
    }
}
