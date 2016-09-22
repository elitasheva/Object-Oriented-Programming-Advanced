package main.problem4;

import javax.naming.OperationNotSupportedException;
import java.util.List;

public class BubbleSort<T extends Comparable<T>> {

    private List<T> numbers;

    public BubbleSort(List<T> numbers) throws OperationNotSupportedException {
        this.setNumbers(numbers);
        this.sort();
    }

    public List<T> getNumbers() {
        return this.numbers;
    }

    private void sort() {
        for (int i = 0; i < this.numbers.size(); i++) {
            for (int j = 0; j < this.numbers.size() - i - 1; j++) {
                if (this.numbers.get(j).compareTo(this.numbers.get(j + 1)) > 0) {
                    this.swap(j, j+1);
                }
            }
        }
    }

    private void swap(int i, int j) {
        T temp = this.numbers.get(i);
        this.numbers.set(i, this.numbers.get(j));
        this.numbers.set(j, temp);
    }

    private void setNumbers(List<T> numbers) throws OperationNotSupportedException {
        if (numbers.size() == 0) {
            throw new OperationNotSupportedException();
        }
        this.numbers = numbers;
    }
}
