package problem7.models;


import problem7.annotations.Setter;

public class Employee extends Entity {

    private String name;
    private int income;

    public Employee(String id, String name, int income) {
        super(id);
        this.name = name;
        this.income = income;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Setter(fieldName = "name", fieldType = "String")
    public void setName(String newValue) {
        String oldValue = this.name;
        this.name = newValue;
        this.fieldChanged("name", oldValue, newValue);
    }

    public int getIncome() {
        return this.income;
    }

    @Setter(fieldName = "income", fieldType = "int")
    public void setIncome(int newIncome) {
        int oldValue = this.income;
        this.income = newIncome;
        this.fieldChanged("income", oldValue, newIncome);
    }

    private <T> void fieldChanged(String filedName, T oldValue, T newValue) {
        Class<?> employeeClass = Employee.class;
        super.fieldChanged(employeeClass, filedName, oldValue, newValue);
    }
}
