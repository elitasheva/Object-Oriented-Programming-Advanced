package problem10.models;

public class Demon extends Character<Integer>{

    private static final String CHARACTER_TYPE = "Demon";

    public Demon(String username, int level, double specialPoints) {
        super(username, CHARACTER_TYPE, level, specialPoints);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(this.getSpecialPoints().doubleValue()*this.getLevel());

        return sb.toString();
    }
}
