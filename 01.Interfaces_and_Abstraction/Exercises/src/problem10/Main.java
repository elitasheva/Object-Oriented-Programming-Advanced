package problem10;

import problem10.interfaces.GameObject;
import problem10.models.Archangel;
import problem10.models.Demon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String[] params = reader.readLine().split("[\\s\\|]+");
            String name = params[0];
            String type = params[1];
            String specialPoints = params[2];
            int level = Integer.parseInt(params[3]);

            switch (type.toLowerCase()) {
                case "demon":
                    Double points = Double.parseDouble(specialPoints);
                    GameObject<Integer> demon = new Demon(name, level, points);
                    demon.setPassword(demon.getUsername().length() * 217);
                    System.out.println(demon.toString());
                    break;
                case "archangel":
                    Integer point = Integer.parseInt(specialPoints);
                    GameObject<String> archangel = new Archangel(name, level, point);
                    StringBuilder sb = new StringBuilder(archangel.getUsername()).reverse();
                    archangel.setPassword(sb.toString() + (archangel.getUsername().length() * 21));
                    System.out.println(archangel.toString());
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
