package problem7;

import problem7.models.Buyer;
import problem7.models.Citizen;
import problem7.models.Rebel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            HashMap<String, Buyer> data = new LinkedHashMap<>();

            int count = Integer.parseInt(reader.readLine());

            for (int i = 0; i < count; i++) {

                String[] params = reader.readLine().split(" ");
                Buyer buyer = null;

                String name = params[0];
                int age = Integer.parseInt(params[1]);

                if (params.length == 4) {
                    String id = params[2];
                    String birthdate = params[3];
                    buyer = new Citizen(name, age, id, birthdate);

                }

                if (params.length == 3) {
                    String group = params[2];
                    buyer = new Rebel(name, age, group);
                }

                data.put(name, buyer);
            }

            while (true){

                String key = reader.readLine();
                if ("End".equals(key)){
                    break;
                }

                if (data.containsKey(key)){
                    Buyer buyer = data.get(key);
                    buyer.buyFood();
                }
            }

            int quantity = data.values().stream().mapToInt(b -> b.getFood()).sum();
            System.out.println(quantity);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
