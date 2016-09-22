package problem7.models;

import problem7.interfaces.CustomList;
import problem7.interfaces.Sorter;


public class CustomSorter<T extends Comparable<T>> implements Sorter<T>{

    @Override
    public void sort(CustomList<T> list) {

        for (int i = 0; i < list.size(); i++) {
            T current = list.getElement(i);
            for (int j = i+1; j < list.size(); j++) {
                if (current.compareTo(list.getElement(j)) > 0){
                    list.swap(i,j);
                }
            }

        }
    }

}
