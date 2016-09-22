package problem10.models;

public class Archangel extends Character<String>{

    private static final String CHARACTER_TYPE = "Archangel";

    public Archangel(String username, int level, int specialPoints) {
        super(username, CHARACTER_TYPE, level, specialPoints);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(this.getSpecialPoints().intValue()*this.getLevel());

        return sb.toString();
    }
}
