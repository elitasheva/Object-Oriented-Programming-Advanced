package problem7.models;


import problem7.annotations.Setter;

public class Company extends Entity {

    private String name;
    private int turnover;
    private int revenue;

    public Company(String id, String name, int turnover, int revenue) {
        super(id);
        this.name = name;
        this.turnover = turnover;
        this.revenue = revenue;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Setter(fieldName = "name", fieldType = "String")
    public void setName(String newName) {
        String oldName = this.name;
        this.name = newName;
        this.fieldChanged("name", oldName, newName);
    }

    public int getTurnover() {
        return this.turnover;
    }

    @Setter(fieldName = "turnover", fieldType = "int")
    public void setTurnover(int turnover) {
        int oldValue = this.turnover;
        this.turnover = turnover;
        this.fieldChanged("turnover", oldValue, turnover);
    }

    public int getRevenue() {
        return this.revenue;
    }


    @Setter(fieldName = "revenue", fieldType = "int")
    public void setRevenue(int revenue) {
        int oldValue = this.revenue;
        this.revenue = revenue;
        this.fieldChanged("revenue", oldValue, revenue);
    }

    private <T> void fieldChanged(String filedName, T oldValue, T newValue) {
        Class<?> companyClass = Company.class;
        super.fieldChanged(companyClass, filedName, oldValue, newValue);
    }

}
