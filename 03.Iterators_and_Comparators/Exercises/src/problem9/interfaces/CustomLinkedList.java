package problem9.interfaces;

public interface CustomLinkedList<T> extends Iterable<T>{
     void add(T element);

    boolean remove(T element);

    int getSize();
}
