package problem8.models;

public class Room {

    private int id;
    private Pet pet;

    public Room(int id) {
        this.id = id;
    }

    public Pet getPet() {
        return this.pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        if (this.pet == null) {
            return String.format("Room empty");
        } else {
            return this.pet.toString();
        }
    }
}
