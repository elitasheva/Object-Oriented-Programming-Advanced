package problem6;

import problem6.models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            List<Birthdate> peopleAndPets = new ArrayList<>();
            List<Id> peopleAndRobots = new ArrayList<>();

            while (true) {
                String[] params = reader.readLine().split(" ");
                String type = params[0];
                if ("End".equals(type)) {
                    break;
                }

                String name = null;
                String birthday = null;
                String id = null;
                switch (type) {
                    case "Citizen":
                        name = params[1];
                        int age = Integer.parseInt(params[2]);
                        id = params[3];
                        birthday = params[4];
                        Citizen citizen = new Citizen(name, age, id, birthday);
                        peopleAndPets.add(citizen);
                        peopleAndRobots.add(citizen);
                        break;
                    case "Pet":
                        name = params[1];
                        birthday = params[2];
                        Pet pet = new Pet(name, birthday);
                        peopleAndPets.add(pet);
                        break;
                    case "Robot":
                        String model = params[1];
                        id = params[2];
                        Robot robot = new Robot(model, id);
                        peopleAndRobots.add(robot);
                        break;
                }

            }

            String key = reader.readLine();
           // boolean hasOutput = false;
            for (Birthdate peopleAndPet : peopleAndPets) {
                if (peopleAndPet.getBirthdate().endsWith(key)){
                    //hasOutput = true;
                    System.out.println(peopleAndPet.getBirthdate());
                }
            }

//            if (!hasOutput){
//                System.out.println("<no output>");
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
