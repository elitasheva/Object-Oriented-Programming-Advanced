package problem10.models;

import problem10.interfaces.GameObject;

public abstract class Character<P> implements GameObject<P>{

    private String username;
    private String type;
    private P password;
    private int level;
    private Number specialPoints;

    protected Character(String username, String type, int level, Number specialPoints) {
        this.setUsername(username);
        this.type = type;
        this.setLevel(level);
        this.setSpecialPoints(specialPoints);
    }

    public String getUsername() {
        return this.username;
    }

    public P getPassword() {
        return this.password;
    }

    public int getLevel() {
        return this.level;
    }

    public Number getSpecialPoints() {
        return this.specialPoints;
    }

    public String getType() {
        return this.type;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(P password) {
        this.password = password;
    }

    private void setLevel(int level) {
        this.level = level;
    }

    private void setSpecialPoints(Number specialPoints) {
        this.specialPoints = specialPoints;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\"%s\" | \"%s\" -> %s%n", this.getUsername(), this.getPassword(), this.getType()));

        return sb.toString();
    }
}
