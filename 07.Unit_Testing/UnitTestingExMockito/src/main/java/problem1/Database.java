package problem1;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;

public class Database {

    private static final int DEFAULT_CAPACITY = 16;

    private Integer[] numbers;
    private int index;
    //private int countOfElements;

    public Database(Integer... numbers) throws OperationNotSupportedException {
        this.numbers = new Integer[DEFAULT_CAPACITY];
        this.setNumbers(numbers);
    }

    public int size() {
        return this.index;
    }

    public void add(Integer number) throws OperationNotSupportedException {
        if (number == null) {
            throw new OperationNotSupportedException();
        }
        this.numbers[index] = number;
        this.index++;
        //this.countOfElements++;
    }

    public void remove() throws OperationNotSupportedException {
        if (this.index == 0) {
            throw new OperationNotSupportedException();
        }
        this.index--;
    }

    public Integer[] toArray() {
        Integer[] newArray = Arrays.copyOf(this.numbers, this.index);

        return newArray;
    }

    private void setNumbers(Integer[] numbers) throws OperationNotSupportedException {
        if (numbers.length > DEFAULT_CAPACITY || numbers.length < 1) {
            throw new OperationNotSupportedException();
        }

        for (Integer number : numbers) {
            this.numbers[index] = number;
            this.index++;
        }

    }
}
