package problem7.interfaces;

public interface Sorter<T extends Comparable<T>> {

    void sort(CustomList<T> list);
}
