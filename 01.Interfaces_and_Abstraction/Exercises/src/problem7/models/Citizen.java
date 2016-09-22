package problem7.models;

public class Citizen extends Person {

    private String id;
    private String birthdate;

    public Citizen(String name, int age, String id, String birthdate) {
        super(name, age);
        this.id = id;
        this.birthdate = birthdate;
    }


    @Override
    public void buyFood() {
        super.setFood(super.getFood() + 10);
    }
}
