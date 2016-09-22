package problem7;

import problem7.models.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        TreeSet<Person> peopleCompare = new TreeSet<>();
        HashSet<Person> peopleHash = new HashSet<>();
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            
            int count = Integer.parseInt(reader.readLine());

            for (int i = 0; i < count; i++) {

                String[] params = reader.readLine().split(" ");
                String name = params[0];
                int age = Integer.parseInt(params[1]);
                Person current = new Person(name,age);
                peopleCompare.add(current);
                peopleHash.add(current);
            }

            System.out.println(peopleCompare.size());
            System.out.println(peopleHash.size());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
