package problem3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StackIteratorImpl<T> implements StackIteratot<T>, Iterable<T> {

    private List<T> collection;

    public StackIteratorImpl() {
        this.collection = new ArrayList<T>();
    }

    public void push(T element) {
        this.collection.add(element);
    }

    public T pop() {
        if (this.collection.size() == 0){
            throw new IllegalArgumentException("No elements");
        }
        return this.collection.remove(this.collection.size() - 1);
    }

    public int size(){
        return this.collection.size();
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = collection.size()-1;

            @Override
            public boolean hasNext() {

                return index >= 0;
            }

            @Override
            public T next() {
                return collection.get(index--);
            }
        };
    }
}
