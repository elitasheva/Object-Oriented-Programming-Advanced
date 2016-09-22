package problem7.models;

import problem7.interfaces.CustomList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomListImpl<T extends Comparable<T>> implements CustomList<T> {

    private List<T> list;

    public CustomListImpl() {
        this.list = new ArrayList<>();
    }


    public void add(T element) {
        this.list.add(element);
    }

    public T remove(int index) {
        if (index < 0 || index > this.list.size()) {
            throw new IndexOutOfBoundsException("Index was out of bounds.");
        }
        return this.list.remove(index);
    }

    public boolean contains(T element) {
        return this.list.contains(element);
    }

    public void swap(int index1, int index2) {
        if (index1 < 0 || index1 > this.list.size()) {
            throw new IndexOutOfBoundsException("Index was out of bounds.");
        }

        if (index2 < 0 || index2 > this.list.size()) {
            throw new IndexOutOfBoundsException("Index was out of bounds.");
        }

        T elementToSwap1 = this.list.get(index1);
        T elementToSwap2 = this.list.get(index2);
        this.list.set(index1, elementToSwap2);
        this.list.set(index2, elementToSwap1);

    }

    public int countGreaterThat(T element) {
        int count = 0;
        for (T current : list) {
            if (current.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public T getMax() {
        if (this.list.isEmpty()) {
            throw new IllegalStateException("List is empty.");
        }

        T maxElement = this.list.get(0);
        for (T current : list) {
            if (current.compareTo(maxElement) > 0) {
                maxElement = current;
            }
        }

        return maxElement;
    }

    public T getMin() {
        if (this.list.isEmpty()) {
            throw new IllegalStateException("List is empty.");
        }

        T minElement = this.list.get(0);
        for (T current : list) {
            if (current.compareTo(minElement) < 0) {
                minElement = current;
            }
        }
        return minElement;
    }

    public int size(){
        return this.list.size();
    }

    public T getElement(int index){
        if (index < 0 || index > this.list.size()){
            throw new IndexOutOfBoundsException("Index was out of bounds.");
        }
        return this.list.get(index);
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {

                return index < list.size();
            }

            @Override
            public T next() {

                return list.get(index++);
            }
        };
    }
}
