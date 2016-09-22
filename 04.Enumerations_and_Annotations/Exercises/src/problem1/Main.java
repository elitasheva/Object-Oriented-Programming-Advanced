package problem1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            String input = reader.readLine();
            System.out.println(input + ":");

            for (Suit suit : Suit.values()) {
                System.out.printf("Ordinal value: %d; Name value: %s%n", suit.ordinal(), suit.name());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
