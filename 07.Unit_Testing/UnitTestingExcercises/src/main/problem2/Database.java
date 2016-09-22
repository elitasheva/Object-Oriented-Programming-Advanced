package main.problem2;

import javax.naming.OperationNotSupportedException;
import java.util.HashMap;
import java.util.LinkedHashMap;


public class Database {

    private static final int DEFAULT_CAPACITY = 5;

    private HashMap<String, Person> peopleByUsername;
    private HashMap<Long, Person> peopleById;

    public Database(Person... people) throws OperationNotSupportedException {
        this.peopleByUsername = new LinkedHashMap<String, Person>();
        this.peopleById = new LinkedHashMap<Long, Person>();
        this.setPeople(people);
    }

    public int size(){
        return this.peopleById.size();
    }

    public void addPerson(Person person) throws OperationNotSupportedException {
        if (person.getId() == null || person.getId() < 0) {
            throw new OperationNotSupportedException();
        }
        if (person.getUsername() == null) {
            throw new OperationNotSupportedException();
        }

        if (this.peopleById.containsKey(person.getId())) {
            throw new OperationNotSupportedException();
        }

        if (this.peopleByUsername.containsKey(person.getUsername())) {
            throw new OperationNotSupportedException();
        }

        this.peopleById.put(person.getId(), person);
        this.peopleByUsername.put(person.getUsername(), person);
    }

    public void remove(Person person) throws OperationNotSupportedException {
        if (!this.peopleById.containsKey(person.getId())) {
            throw new OperationNotSupportedException();
        }

        if (!this.peopleByUsername.containsKey(person.getUsername())) {
            throw new OperationNotSupportedException();
        }

        this.peopleById.remove(person.getId());
        this.peopleByUsername.remove(person.getUsername());
    }

    public Person findByUsername(String username) throws OperationNotSupportedException {
        if (!this.peopleByUsername.containsKey(username)) {
            throw new OperationNotSupportedException();
        }
        return this.peopleByUsername.get(username);
    }

    public Person findById(Long id) throws OperationNotSupportedException {
        if (!this.peopleById.containsKey(id)) {
            throw new OperationNotSupportedException();
        }
        return this.peopleById.get(id);
    }


    private void setPeople(Person[] people) throws OperationNotSupportedException {
        if (people.length > DEFAULT_CAPACITY || people.length < 0) {
            throw new OperationNotSupportedException();
        }

        if (people != null){
            for (Person person : people) {
                this.addPerson(person);
            }
        }
    }
}
