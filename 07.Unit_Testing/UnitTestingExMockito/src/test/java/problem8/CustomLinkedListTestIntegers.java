package problem8;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomLinkedListTestIntegers {

    private CustomLinkedList<Integer> customLinkedList;

    @Before
    public void setUp() {
        this.customLinkedList = new CustomLinkedList<>();
    }

    @Test
    public void testCountEmptyListShouldReturnZero() {
        Assert.assertEquals("Incorrect size", 0, this.customLinkedList.getCount());
    }

    @Test
    public void testAddElementShouldIncreaseTheSize() {
        this.customLinkedList.add(5);
        this.customLinkedList.add(10);
        int expected = 2;
        int actual = this.customLinkedList.getCount();

        Assert.assertEquals("add method does not work correctly", expected, actual);
    }

    @Test
    public void testContainsAddedElementShouldReturnTrue() {
        this.customLinkedList.add(5);
        this.customLinkedList.add(10);

        Assert.assertTrue("contains method does not work correctly", this.customLinkedList.contains(5));
    }

    @Test
    public void testContainsNonExistentElementShouldReturnFalse() {
        this.customLinkedList.add(5);
        this.customLinkedList.add(10);

        Assert.assertFalse("contains method does not work correctly", this.customLinkedList.contains(15));
    }

    @Test
    public void testGetElementByIndexValidIndexShouldRetunElement() {
        this.customLinkedList.add(5);
        this.customLinkedList.add(10);
        int actualElement = this.customLinkedList.get(1);
        int expectedElement = 10;

        Assert.assertEquals("get element by index does not work correctly", expectedElement, actualElement);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetElementByIndexNegativIndexShouldThrowException() {
        this.customLinkedList.add(5);
        this.customLinkedList.add(10);
        int actualElement = this.customLinkedList.get(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetElementByIndexIndexBiggerThenSizeShouldThrowException() {
        this.customLinkedList.add(5);
        this.customLinkedList.add(10);
        int actualElement = this.customLinkedList.get(5);
    }

    @Test
    public void testSetElementByIndexGetByIndexShouldReturnTheElement() {
        this.customLinkedList.add(6);
        this.customLinkedList.add(6);
        this.customLinkedList.add(6);

        this.customLinkedList.set(2, 8);

        int expectedElement = 8;
        int actualElement = this.customLinkedList.get(2);

        Assert.assertEquals("set method does not work correctly", expectedElement, actualElement);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetElementNegativeIndexShouldThrowException() {
        this.customLinkedList.set(-1, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetElementIndexBiggerThenSizeShouldThrowException() {
        this.customLinkedList.set(2, 5);
    }

    @Test
    public void testIndexOfAddedElementShouldReturnCorrectIndex() {
        this.customLinkedList.add(5);
        this.customLinkedList.add(6);
        this.customLinkedList.add(8);

        int expectedIndex = 0;
        int actualIndex = this.customLinkedList.indexOf(5);

        Assert.assertEquals("indexOf method does not work correctly", expectedIndex, actualIndex);
    }

    @Test
    public void testIndexOfNonExistentElementShouldReturnMinusOne() {
        this.customLinkedList.add(5);
        this.customLinkedList.add(6);
        this.customLinkedList.add(8);

        int expectedIndex = -1;
        int actualIndex = this.customLinkedList.indexOf(10);

        Assert.assertEquals("indexOf method does not work correctly", expectedIndex, actualIndex);
    }

    @Test
    public void testRemoveAtValidIndexShouldReturnTheElement() {
        this.customLinkedList.add(5);
        this.customLinkedList.add(6);
        this.customLinkedList.add(8);

        int expectedElement = 6;
        int actualElement = this.customLinkedList.removeAt(1);

        Assert.assertEquals("removeAt method does not work correctly", expectedElement, actualElement);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtNegativeIndexShouldThrowException() {
        this.customLinkedList.add(5);
        this.customLinkedList.add(6);
        this.customLinkedList.add(8);

        int actualElement = this.customLinkedList.removeAt(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtIndexBiggerThenSizeShouldThrowException() {
        this.customLinkedList.add(5);
        this.customLinkedList.add(6);
        this.customLinkedList.add(8);

        int actualElement = this.customLinkedList.removeAt(5);
    }

    @Test
    public void testRemoveElementExistentElementShouldReturnTheCorrectIndex(){
        this.customLinkedList.add(5);
        this.customLinkedList.add(6);
        this.customLinkedList.add(8);

        int expectedIndex = 2;
        int actualIndex = this.customLinkedList.remove(8);

        Assert.assertEquals("remove method does not work correctly", expectedIndex, actualIndex);
    }

    @Test
    public void testRemoveElementNonExistentElementShouldReturnMinusOne(){
        this.customLinkedList.add(5);
        this.customLinkedList.add(6);
        this.customLinkedList.add(8);

        int expectedIndex = -1;
        int actualIndex = this.customLinkedList.remove(10);

        Assert.assertEquals("remove method does not work correctly", expectedIndex, actualIndex);
    }
}
