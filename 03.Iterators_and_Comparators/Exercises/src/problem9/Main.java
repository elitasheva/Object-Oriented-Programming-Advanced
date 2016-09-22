package problem9;

import problem9.interfaces.CustomLinkedList;
import problem9.models.CustomLinkedListImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        //TODO test 3 is not correct we never add number 7 and test one missing size in the first row
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            CustomLinkedList<Integer> customLinkedList = new CustomLinkedListImpl<>();
            int countOfCommands = Integer.parseInt(reader.readLine());

            for (int i = 0; i < countOfCommands; i++) {
                String[] params = reader.readLine().split(" ");
                String command = params[0];
                int value = Integer.parseInt(params[1]);;
                switch (command){
                    case "Add":
                        customLinkedList.add(value);
                        break;
                    case "Remove":
                        customLinkedList.remove(value);
                        break;
                }
            }

            System.out.println(customLinkedList.getSize());

            for (Integer current : customLinkedList) {
                System.out.print(current + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
