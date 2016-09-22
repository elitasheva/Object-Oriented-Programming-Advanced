package problem10.models;

public class Axe extends Weapon{

    private static final int DEFAULT_MIN_DAMAGE = 5;
    private static final int DEFAULT_MAX_DAMAGE = 10;
    private static final int DEFAULT_COUNT_OF_SOCKETS = 4;


    public Axe(String name) {
        super(name, DEFAULT_MIN_DAMAGE, DEFAULT_MAX_DAMAGE, DEFAULT_COUNT_OF_SOCKETS);
    }
}
