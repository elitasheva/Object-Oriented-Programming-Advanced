package test.problem4;

import main.problem4.BubbleSort;
import org.junit.Assert;
import org.junit.Test;


import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BubbleSortTest {

    private BubbleSort bubbleSort;

    @Test(expected = OperationNotSupportedException.class)
    public void sortEmptyCollectionShouldThrowException() throws OperationNotSupportedException {
        List<Integer> numbers = new ArrayList<Integer>();
        this.bubbleSort = new BubbleSort(numbers);

    }

    @Test
    public void sortThreeElementsShouldReturnSortedCollection() throws OperationNotSupportedException {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(10);
        numbers.add(2);
        numbers.add(50);
        this.bubbleSort = new BubbleSort(numbers);
        List<Integer> actualCollection = this.bubbleSort.getNumbers();
        Collections.sort(numbers);

        for (int i = 0; i < numbers.size(); i++) {
            Assert.assertTrue(actualCollection.get(i) == numbers.get(i));
        }

    }

    @Test
    public void sortTenElementsShouldReturnSortedCollection() throws OperationNotSupportedException {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(10);
        numbers.add(2);
        numbers.add(50);
        numbers.add(6);
        numbers.add(0);
        numbers.add(65);
        numbers.add(15);
        numbers.add(35);
        numbers.add(77);
        numbers.add(100);
        this.bubbleSort = new BubbleSort(numbers);
        List<Integer> actualCollection = this.bubbleSort.getNumbers();
        Collections.sort(numbers);

        for (int i = 0; i < numbers.size(); i++) {
            Assert.assertTrue(actualCollection.get(i) == numbers.get(i));
        }

    }

    @Test
    public void sortStringsShouldReturnSortedCollection() throws OperationNotSupportedException {
        List<String> strings = new ArrayList<String>();
        strings.add("nnn");
        strings.add("lll");
        strings.add("aaa");
        strings.add("ggg");
        this.bubbleSort = new BubbleSort(strings);
        List<String> actualCollection = this.bubbleSort.getNumbers();
        Collections.sort(strings);

        for (int i = 0; i < strings.size(); i++) {
            Assert.assertTrue(actualCollection.get(i) == strings.get(i));
        }

    }

//    @Test
//    public void testMock() {
//        Mockito m = null;
//        List numbers = Mockito.mock(List.class);
//        Mockito.when(numbers.size()).thenReturn(5);
//        Mockito m = null;
//        Assert.assertTrue(numbers.size() == 5);
//    }
}
