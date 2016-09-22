package problem2;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListyIterator<T> implements Iterable<T> {

    private List<T> collection;
    private int index;

    public ListyIterator(List<T> collection) {
        this.collection = collection;
        this.index = 0;
    }

    public boolean move() {
        if (hasNext()) {
            index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        if (this.index < this.collection.size() - 1) {
            return true;
        }
        return false;

    }

    public T print() {
        if (this.collection.isEmpty()) {
            throw new InvalidOperationException("Invalid Operation!");
        }
        return this.collection.get(this.index);
    }

    public void printAll() {
        this.collection.forEach(x -> System.out.print(x + " "));
        System.out.println();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index;

            @Override
            public boolean hasNext() {
                return index < collection.size();
            }

            @Override
            public T next() {
                return collection.get(index++);
            }
        };
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        this.collection.forEach(action::accept);

    }

}
