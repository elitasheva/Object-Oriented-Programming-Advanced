package problem7.models;

import java.util.Comparator;

public class Person implements Comparable<Person> {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person other) {
        int compare = this.name.compareTo(other.name);
        if (compare == 0) {
            compare = Integer.compare(this.age, other.age);
        }
        return compare;
    }

    @Override
    public boolean equals(Object other) {
        //check reference
        if (this == other) {
            return true;
        }

        //check other for null and are the classes the same
        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        Person person = (Person) other;

        if (this.name == null || !this.name.equals(person.name)) {
            return false;
        }
        if (this.age != person.age) {
            return false;
        }
        return true;
    }

//    if (this == o) {
//        return true;}
//    if (o == null || getClass() != o.getClass()){
//        return false;}
//
//    Person person = (Person) o;
//
//    if (age != person.age) return false;
//    return name != null ? name.equals(person.name) : person.name == null;

    @Override
    public int hashCode() {
        int result = this.name != null ? this.name.hashCode() : 0;
        result = 31 * result + this.age;
        return result;
    }


}
