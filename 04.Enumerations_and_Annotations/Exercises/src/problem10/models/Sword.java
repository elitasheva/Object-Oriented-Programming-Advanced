package problem10.models;

public class Sword extends Weapon{

    private static final int DEFAULT_MIN_DAMAGE = 4;
    private static final int DEFAULT_MAX_DAMAGE = 6;
    private static final int DEFAULT_COUNT_OF_SOCKETS = 3;


    public Sword(String name) {
        super(name, DEFAULT_MIN_DAMAGE, DEFAULT_MAX_DAMAGE, DEFAULT_COUNT_OF_SOCKETS);
    }
}
