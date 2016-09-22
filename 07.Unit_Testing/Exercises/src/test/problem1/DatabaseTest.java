package problem1;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private Database database;

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithMoreElementsShouldThrowException() throws OperationNotSupportedException {
        this.database = new Database(1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 1, 1, 1, 1, 1, 1, 1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithNoElementsShouldThrowException() throws OperationNotSupportedException {
        this.database = new Database();
    }

    @Test
    public void addElementShouldBeTheLastElement() throws OperationNotSupportedException {
        this.database = new Database(1, 2, 3, 4);
        int elementToAdd = 5;
        this.database.add(elementToAdd);
        int expectedIndex = 4;

        Assert.assertTrue(this.database.toArray()[expectedIndex] == elementToAdd);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addElementWithValueNullShouldThrowException() throws OperationNotSupportedException {
        this.database = new Database(1, 2, 3, 4);
        this.database.add(null);

    }

    @Test
    public void addElementsShouldReturnCorrectSize() throws OperationNotSupportedException {
        this.database = new Database(1, 2, 3, 4);
        int actualSize = this.database.size();
        int expectedSize = 4;

        Assert.assertTrue(actualSize == expectedSize);
    }

    @Test
    public void addElementsRemoveOneShouldReturnCorrectSize() throws OperationNotSupportedException {
        this.database = new Database(1, 2, 3, 4);
        this.database.remove();
        int actualSize = this.database.size();
        int expectedSize = 3;

        Assert.assertTrue(actualSize == expectedSize);
    }

    @Test
    public void addElementsRemoveOneShouldReturnCorrectElement() throws OperationNotSupportedException {
        this.database = new Database(1, 2, 3, 4);
        this.database.remove();
        int actualElement = this.database.toArray()[2];
        int expectedElement = 3;

        Assert.assertTrue(actualElement == expectedElement);

    }

    @Test
    public void addElementsRemoveAllShouldReturnCorrectSize() throws OperationNotSupportedException {
        this.database = new Database(1, 2, 3, 4);
        this.database.remove();
        this.database.remove();
        this.database.remove();
        this.database.remove();
        int actualSize = this.database.size();
        int expectedSize = 0;

        Assert.assertTrue(actualSize == expectedSize);
    }

    @Test
    public void addElementsRemoveOneShouldReturnCorrectCollection() throws OperationNotSupportedException {
        this.database = new Database(1, 2, 3, 4);
        this.database.remove();
        Integer[] actualCollection = this.database.toArray();
        Integer[] expectedCollection = {1, 2, 3};

        Assert.assertArrayEquals(actualCollection,expectedCollection);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeElementFromEmptyCollectionShouldThrowException() throws OperationNotSupportedException {
        this.database = new Database();
        this.database.remove();
    }


}
