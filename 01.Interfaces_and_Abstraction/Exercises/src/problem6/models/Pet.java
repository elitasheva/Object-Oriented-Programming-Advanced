package problem6.models;

public class Pet implements Birthdate{
    private String name;
    private String birthday;

    public Pet(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String getBirthdate() {
        return this.birthday;
    }
}
