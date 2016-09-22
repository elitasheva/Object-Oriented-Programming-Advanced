package problem;

import problem.models.Battlefield;
import problem.models.Dragon;
import problem.models.Item;
import problem.models.Warrior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String[] dragonParams = reader.readLine().split("[\\s]+");
            String dragonName = dragonParams[0];
            int dragonPower = Integer.parseInt(dragonParams[1]);
            int dragonHealth = Integer.parseInt(dragonParams[2]);
            String itemName = dragonParams[3];
            String itemType = dragonParams[4];
            int itemPoints = Integer.parseInt(dragonParams[5]);
            Item item = new Item(itemName, itemType, itemPoints);
            Dragon dragon = new Dragon(dragonName, dragonPower, dragonHealth, item);

            List<Warrior> warriors = new ArrayList<>();
            while (true) {
                String input = reader.readLine();
                if ("Skyrim".equals(input)) {
                    break;
                }

                String[] warriorParams = input.split("[\\s]+");
                String warriorName = warriorParams[0];
                int warriorExpirience = Integer.parseInt(warriorParams[1]);
                int warriorPower = Integer.parseInt(warriorParams[2]);
                int warriorHealth = Integer.parseInt(warriorParams[3]);
                Warrior warrior = new Warrior(warriorName, warriorExpirience, warriorPower, warriorHealth);
                warriors.add(warrior);
            }

            Battlefield battlefield = new Battlefield(dragon, warriors);
            dragon.addDragonDeathListener(battlefield);

            battlefield.applyFight();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
