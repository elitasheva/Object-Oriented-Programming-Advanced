package test.problem3;

import main.problem3.ListIterator;
import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;


public class ListIteratorTest {

    private ListIterator listIterator;

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorAddEmptyListShouldThrowexception() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(new ArrayList<String>());
    }

    @Test
    public void testConstructorAddedSomeElementsShouldReturnCorrectSize() throws OperationNotSupportedException {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        this.listIterator = new ListIterator(list);
        int actualSize = this.listIterator.size();
        int expectedSize = 3;

        Assert.assertTrue(actualSize == expectedSize);
    }

    @Test
    public void hasNextCollectionWithOneElementShouldReturnFalse() throws OperationNotSupportedException {
        List<String> list = new ArrayList<String>();
        list.add("1");
        this.listIterator = new ListIterator(list);

        Assert.assertFalse(listIterator.hasNext());
    }

    @Test
    public void hasNextCollectionWithTwoElementsShouldReturnTrue() throws OperationNotSupportedException {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        this.listIterator = new ListIterator(list);

        Assert.assertTrue(listIterator.hasNext());
    }

    @Test
    public void moveCollectionWithOneElementShouldReturnFalse() throws OperationNotSupportedException {
        List<String> list = new ArrayList<String>();
        list.add("1");
        this.listIterator = new ListIterator(list);

        Assert.assertFalse(listIterator.move());
    }

    @Test
    public void moveCollectionWithTwoElementsShouldReturnTrue() throws OperationNotSupportedException {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        this.listIterator = new ListIterator(list);

        Assert.assertTrue(listIterator.move());
    }

    @Test
    public void collectionWithThreeElementsTwoTimesMoveHasNextShouldReturnFalse() throws OperationNotSupportedException {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        this.listIterator = new ListIterator(list);

        Assert.assertTrue(this.listIterator.move());
        Assert.assertTrue(this.listIterator.move());
        Assert.assertFalse(this.listIterator.hasNext());
    }

    @Test
    public void printElementShouldReturnCorrectElement() throws OperationNotSupportedException {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        this.listIterator = new ListIterator(list);

        Assert.assertTrue(this.listIterator.print().equals("1"));
        this.listIterator.move();
        Assert.assertTrue(this.listIterator.print().equals("2"));
        this.listIterator.move();
        Assert.assertTrue(this.listIterator.print().equals("3"));
    }
}
