package problem5.models;

public abstract class Citizen {
    private String id;

    protected Citizen(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}
