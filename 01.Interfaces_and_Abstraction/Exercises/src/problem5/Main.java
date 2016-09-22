package problem5;

import problem5.models.Citizen;
import problem5.models.Human;
import problem5.models.Robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            List<Citizen> citizens = new ArrayList<>();

            while (true) {
                String input = reader.readLine();
                if ("End".equals(input)) {
                    break;
                }
                String[] params = input.split(" ");

                Citizen current = null;
                if (params.length == 3) {
                    String name = params[0];
                    int age = Integer.parseInt(params[1]);
                    String id = params[2];
                    current = new Human(name, age, id);
                }

                if (params.length == 2){
                    String model = params[0];
                    String id = params[1];
                    current = new Robot(model,id);
                }

                citizens.add(current);
            }

            String fake = reader.readLine();
            for (Citizen citizen : citizens) {
                if (citizen.getId().endsWith(fake)){
                    System.out.println(citizen.getId());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
