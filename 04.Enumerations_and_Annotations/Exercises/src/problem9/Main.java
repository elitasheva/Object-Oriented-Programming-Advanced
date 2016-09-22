package problem9;

import problem9.enums.Light;
import problem9.models.TrafficLight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){


            String[] currentInput = reader.readLine().split("\\s+");
            List<Light> currentState = new ArrayList<>();
            for (String s : currentInput) {
                Light currentLight = Light.valueOf(s);
                currentState.add(currentLight);
            }

            TrafficLight trafficLight = new TrafficLight(currentState);
            int count = Integer.parseInt(reader.readLine());
            for (int i = 0; i < count; i++) {
                List<Light> current = new ArrayList<>();
                for (Light light : trafficLight.getCurrentState()) {
                    Light newLight = trafficLight.changeLight(light);
                    current.add(newLight);
                    System.out.print(newLight + " ");
                }
                trafficLight.setCurrentState(current);
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
