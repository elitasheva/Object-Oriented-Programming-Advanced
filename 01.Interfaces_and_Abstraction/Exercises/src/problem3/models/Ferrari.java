package problem3.models;

public class Ferrari implements Car {

    private static final String DEFAULT_MODEL = "488-Spider";
    private String model;
    private String driverName;

    public Ferrari(String driverName) {
        this.setDriverName(driverName);
        this.model = DEFAULT_MODEL;
    }

    public String getModel() {
        return this.model;
    }

    public String getDriverName() {
        return this.driverName;
    }

    private void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String pushBrakes() {
        return "Brakes!";
    }

    @Override
    public String pushGasPedal() {
        return "Zadu6avam sA!";
    }
}
