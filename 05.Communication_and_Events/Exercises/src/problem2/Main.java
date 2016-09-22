package problem2;

import problem2.models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            CustomMap<String, Unit> units = new CustomMap<>();
            String kingName = reader.readLine();
            King king = new King(kingName);
            String[] namesOfRoyalGuards = reader.readLine().split("[\\s]+");
            for (String currentName : namesOfRoyalGuards) {
                RoyalGuard royalGuard = new RoyalGuard(currentName);
                units.put(currentName, royalGuard);
                king.addAttackListener(royalGuard);
                royalGuard.addListener(units);
                royalGuard.addListener(king);
            }

            String[] namesOfFootmans = reader.readLine().split("[\\s]+");
            for (String currentName : namesOfFootmans) {
                Footman footman = new Footman(currentName);
                units.put(currentName, footman);
                king.addAttackListener(footman);
                footman.addListener(units);
                footman.addListener(king);
            }

            while (true) {
                String[] commandParams = reader.readLine().split("[\\s]+");
                String command = commandParams[0];
                if ("End".equals(command)) {
                    break;
                }

                switch (command) {
                    case "Attack":
                        king.respondToAttack();
                        break;
                    case "Kill":
                        String nameUnit = commandParams[1];
                        Unit currentUnit = units.get(nameUnit);
                        currentUnit.respondToAttack();
                        break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
