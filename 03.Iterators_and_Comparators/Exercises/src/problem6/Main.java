package problem6;


import problem6.models.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

//        Comparator<Person> compareByName = new Comparator<Person>() {
//            @Override
//            public int compare(Person first, Person second) {
//                int compare = Integer.compare(first.getName().length(), second.getName().length());
//                if (compare == 0) {
//                    String symbolOne = String.valueOf(first.getName().charAt(0));
//                    String symbolTwo = String.valueOf(second.getName().charAt(0));
//                    compare = symbolOne.compareToIgnoreCase(symbolTwo);
//                }
//                return compare;
//            }
//
//        };

//        Comparator<Person> compareByAge = new Comparator<Person>() {
//            @Override
//            public int compare(Person first, Person second) {
//                return Integer.compare(first.getAge(), second.getAge());
//            }
//        };

        TreeSet<Person> peopleByName = new TreeSet<>(PersonComparator.COMPARE_BY_NAME);
        TreeSet<Person> peopleByAge = new TreeSet<>(PersonComparator.COMPARE_BY_AGE);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int count = Integer.parseInt(reader.readLine());
            for (int i = 0; i < count; i++) {
                String[] params = reader.readLine().split(" ");
                String name = params[0];
                int age = Integer.parseInt(params[1]);
                Person current = new Person(name, age);
                peopleByName.add(current);
                peopleByAge.add(current);
            }

            for (Person person : peopleByName) {
                System.out.println(person);
            }

            for (Person person : peopleByAge) {
                System.out.println(person);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
