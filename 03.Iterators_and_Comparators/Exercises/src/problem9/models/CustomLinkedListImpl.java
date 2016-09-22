package problem9.models;

import problem9.interfaces.CustomLinkedList;

import java.util.Iterator;

public class CustomLinkedListImpl<T extends Comparable<T>> implements CustomLinkedList<T>, Iterable<T> {
    private int count;
    private Node<T> first;
    private Node<T> current;

    public CustomLinkedListImpl() {
        this.count = 0;
    }

    @Override
    public void add(T element) {

        Node<T> node = new Node<T>(element);
        if (this.first == null){
            this.first = node;
            this.current = node;
        }else {
            this.current.setNext(node);
            this.current = this.current.getNext();
        }
        this.count++;
    }

    @Override
    public boolean remove(T element) {
        if (this.first == null){
            return false;
        }

        Node<T> currentNode = this.first;
        Node<T> prevNode = null;
        while (currentNode != null){

            if (currentNode.getValue().compareTo(element) == 0){

                if (prevNode == null){
                    this.first = this.first.getNext();
                }else {
                    prevNode.setNext(currentNode.getNext());
                }

                this.count--;
                return true;
            }
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }
        return false;
    }

    @Override
    public int getSize() {
        return this.count;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index;
            Node<T> current = first;
            @Override
            public boolean hasNext() {
                return index < count;
            }

            @Override
            public T next() {
                T element = current.getValue();
                current = current.getNext();
                index++;
                return element;
            }
        };
    }

}
