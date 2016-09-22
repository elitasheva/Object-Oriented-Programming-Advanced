package problem5;

import problem5.models.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            List<Person> people = new ArrayList<>();

            while (true) {
                String input = reader.readLine();
                if ("END".equals(input)) {
                    break;
                }

                String[] params = input.split(" ");
                String name = params[0];
                int age = Integer.parseInt(params[1]);
                String town = params[2];
                Person person = new Person(name, age, town);
                people.add(person);
            }


            int index = Integer.parseInt(reader.readLine());
            int countOfEqual = 0;
            if (index < people.size()) {
                Person current = people.get(index);
                for (Person person : people) {
                    if (current.compareTo(person) == 0) {
                        countOfEqual++;
                    }
                }
            }

            if (countOfEqual == 0) {
                System.out.println("No matches");
            } else {
                System.out.printf("%d %d %d", countOfEqual, people.size() - countOfEqual, people.size());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
