package problem10.interfaces;

public interface GameObject<P> {

    String getUsername();

    P getPassword();

    int getLevel();

    Number getSpecialPoints();

    void setPassword(P password);
}
