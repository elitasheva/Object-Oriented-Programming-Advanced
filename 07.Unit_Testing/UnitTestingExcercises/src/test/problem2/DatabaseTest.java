package test.problem2;

import main.problem2.Database;
import main.problem2.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private Database database;

    @Test
    public void testConstructorAddedPeopleShouldReturnCorrectSize() throws OperationNotSupportedException {
        Person person1 = new Person(1L,"pesho");
        Person person2 = new Person(2L,"gosho");
        Person person3 = new Person(3L,"mitko");

        this.database = new Database(person1, person2, person3);
        int actualSize = this.database.size();
        int expectedSize = 3;

        Assert.assertTrue(actualSize == expectedSize);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithMoreElementsShouldThrowException() throws OperationNotSupportedException {
        Person person1 = new Person(1L,"pesho1");
        Person person2 = new Person(2L,"pesho2");
        Person person3 = new Person(3L,"pesho3");
        Person person4 = new Person(4L,"pesho4");
        Person person5 = new Person(5L,"pesho5");
        Person person6 = new Person(6L,"pesho6");

        this.database = new Database(person1, person2, person3, person4, person5, person6);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void addPersonWithIdNullShouldThrowExceprion() throws OperationNotSupportedException {
        this.database = new Database();
        Person personToAdd = new Person(null, "pesho");
        this.database.addPerson(personToAdd);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addPersonWithUsernameNullShouldThrowExceprion() throws OperationNotSupportedException {
        this.database = new Database();
        Person personToAdd = new Person(2L, null);
        this.database.addPerson(personToAdd);
    }

    @Test
    public void addCorrectPersonShouldAddThePerson() throws OperationNotSupportedException {
        this.database = new Database();
        Person personToAdd = new Person(2L, "person");
        this.database.addPerson(personToAdd);
        int actualSize = this.database.size();
        int expectedSize = 1;

        Assert.assertTrue(actualSize == expectedSize);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addTwoPeopleWithTheSameIdShouldThrowException() throws OperationNotSupportedException {
        this.database = new Database();
        Person personToAdd1 = new Person(2L, "person");
        Person personToAdd2 = new Person(2L, "gosho");
        this.database.addPerson(personToAdd1);
        this.database.addPerson(personToAdd2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addTwoPeopleWithTheSameUsernameShouldThrowException() throws OperationNotSupportedException {
        this.database = new Database();
        Person personToAdd1 = new Person(1L, "gosho");
        Person personToAdd2 = new Person(2L, "gosho");
        this.database.addPerson(personToAdd1);
        this.database.addPerson(personToAdd2);
    }

    @Test
    public void removeExistentPersonShouldRemoveThePerson() throws OperationNotSupportedException {
        Person personToAdd = new Person(1L, "gosho");
        this.database = new Database(personToAdd);
        this.database.remove(personToAdd);
        int actualSize = this.database.size();
        int expectedSize = 0;

        Assert.assertTrue(actualSize == expectedSize);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeNonExistentPersonShouldThrowException() throws OperationNotSupportedException {
        Person personToAdd = new Person(1L, "gosho");
        this.database = new Database(personToAdd);
        Person personToRemove = new Person(2L,"pesho");
        this.database.remove(personToRemove);
    }

    @Test
    public void findPersonByIdExistentPersonShouldReturnThePerson() throws OperationNotSupportedException {
        Person personToAdd = new Person(1L, "gosho");
        this.database = new Database(personToAdd);
        Person find = this.database.findById(1L);

        Assert.assertTrue(personToAdd == find);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findPersonByIdNonExistentPersonShouldThrowException() throws OperationNotSupportedException {
        Person personToAdd = new Person(1L, "gosho");
        this.database = new Database(personToAdd);
        Person find = this.database.findById(2L);

    }

    @Test
    public void findPersonByUsernameExistentPersonShouldReturnThePerson() throws OperationNotSupportedException {
        Person personToAdd = new Person(1L, "gosho");
        this.database = new Database(personToAdd);
        Person find = this.database.findByUsername("gosho");

        Assert.assertTrue(personToAdd == find);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findPersonByUsernameNonExistentPersonShouldThrowException() throws OperationNotSupportedException {
        Person personToAdd = new Person(1L, "gosho");
        this.database = new Database(personToAdd);
        Person find = this.database.findByUsername("pesho");

    }
}
