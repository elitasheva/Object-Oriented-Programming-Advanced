package problem5.models;

public class Robot extends Citizen{

    private String model;

    public Robot(String model, String id) {
        super(id);
        this.model = model;
    }

}
