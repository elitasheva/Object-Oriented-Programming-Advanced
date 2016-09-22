package problem7.interfaces;

public interface CustomList<T extends Comparable<T>> extends Iterable<T>{

    void add(T element);

    T remove(int index);

    boolean contains(T element);

    void swap(int index1, int index2);

    int countGreaterThat(T element);

    T getMax();

    T getMin();

    int size();

    T getElement(int index);

}
