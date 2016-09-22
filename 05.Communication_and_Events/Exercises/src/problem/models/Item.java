package problem.models;

public class Item {

    private String name;
    private String typeBonus;
    private int points;


    public Item(String name, String typeBonus, int points) {
        this.setName(name);
        this.setTypeBonus(typeBonus);
        this.setPoints(points);
    }

    public String getName() {
        return this.name;
    }

    public String getTypeBonus() {
        return this.typeBonus;
    }

    public int getPoints() {
        return this.points;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setTypeBonus(String typeBonus) {
        this.typeBonus = typeBonus;
    }

    private void setPoints(int points) {
        this.points = points;
    }
}
