package problem6.models;

public class Citizen implements Id,Birthdate{
    private String name;
    private int age;
    private String id;
    private String birthday;

    public Citizen(String name, int age, String id, String birthday) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthday = birthday;
    }

    @Override
    public String getBirthdate() {
        return this.birthday;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
