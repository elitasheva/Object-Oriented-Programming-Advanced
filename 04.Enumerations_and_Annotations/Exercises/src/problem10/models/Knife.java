package problem10.models;

public class Knife extends Weapon{

    private static final int DEFAULT_MIN_DAMAGE = 3;
    private static final int DEFAULT_MAX_DAMAGE = 4;
    private static final int DEFAULT_COUNT_OF_SOCKETS = 2;


    public Knife(String name) {
        super(name, DEFAULT_MIN_DAMAGE, DEFAULT_MAX_DAMAGE, DEFAULT_COUNT_OF_SOCKETS);
    }
}
