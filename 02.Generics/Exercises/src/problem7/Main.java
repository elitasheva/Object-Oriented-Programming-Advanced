package problem7;

import problem7.interfaces.CommandInterpreter;
import problem7.interfaces.Sorter;
import problem7.models.CommandInterpeterImpl;
import problem7.models.CustomListImpl;
import problem7.models.CustomSorter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            CustomListImpl customList = new CustomListImpl();
            Sorter sorter = new CustomSorter();
            CommandInterpreter commandInterpreter = new CommandInterpeterImpl(customList, sorter);

            while (true){

                String command = reader.readLine();
                if ("END".equals(command)){
                    break;
                }

                try {
                    commandInterpreter.interpreteCommand(command);
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
