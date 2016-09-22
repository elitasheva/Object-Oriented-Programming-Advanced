package problem9;

import problem9.models.AddCollection;
import problem9.models.AddRemoveCollection;
import problem9.models.MyList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            AddCollection addCollection = new AddCollection();
            AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
            MyList myList = new MyList();

            String[] collection = reader.readLine().split(" ");
            addElements(collection, addCollection);
            addElements(collection,addRemoveCollection);
            addElements(collection, myList);

            int countOfRemove = Integer.parseInt(reader.readLine());
            removeElements(countOfRemove, addRemoveCollection);
            removeElements(countOfRemove, myList);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void removeElements(int countOfRemove, AddRemoveCollection addRemoveCollection) {
        for (int i = 0; i < countOfRemove; i++) {
            System.out.print(addRemoveCollection.remove() + " ");
        }
        System.out.println();
    }

    private static void addElements(String[] collection, AddCollection addCollection) {

        for (String s : collection) {
            System.out.print(addCollection.add(s) + " ");
        }
        System.out.println();
    }
}
