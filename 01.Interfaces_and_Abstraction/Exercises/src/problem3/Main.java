package problem3;

import problem3.models.Car;
import problem3.models.Ferrari;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.instrument.IllegalClassFormatException;

public class Main {

    public static void main(String[] args) throws IllegalClassFormatException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            String name = reader.readLine();
            Car ferrari = new Ferrari(name);
            System.out.printf("%s/%s/%s/%s",
                    ferrari.getModel(),ferrari.pushBrakes(),ferrari.pushGasPedal(),ferrari.getDriverName());

            String ferrariName = Ferrari.class.getSimpleName();
            String carInterface = Car.class.getSimpleName();
            boolean isCreated = Car.class.isInterface();
            if (!isCreated) {
                throw new IllegalClassFormatException("No interface created!");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
