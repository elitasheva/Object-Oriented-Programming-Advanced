package problem1;

import problem1.models.Dispatcher;
import problem1.models.Handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        Dispatcher dispatcher = new Dispatcher();
        Handler subscriber = new Handler();
        dispatcher.addNameChangeListener(subscriber);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            while (true){

                String input = reader.readLine();
                if ("End".equals(input)){
                    break;
                }

                dispatcher.setName(input);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
