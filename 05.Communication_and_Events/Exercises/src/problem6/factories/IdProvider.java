package problem6.factories;

public class IdProvider {
    private static int id = 0;

    public static int next(){
        return id++;
    }
}
