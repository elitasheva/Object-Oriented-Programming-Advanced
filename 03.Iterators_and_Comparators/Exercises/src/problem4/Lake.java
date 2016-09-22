package problem4;

import java.util.Iterator;
import java.util.List;

public class Lake<T> implements Iterable<T> {

    private static final int STEP = 2;

    private List<T> collection;
    private int startIndex;


    public Lake(List<T> collection) {
        this.collection = collection;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index;
            int nextStep;

            @Override
            public boolean hasNext() {
                nextStep = startIndex + index * STEP;

                if (collection.size() == 1){
                    return false;
                }

                if (nextStep >= collection.size() && startIndex < 1) {
                    startIndex++;
                    index = 0;
                    nextStep = startIndex + index * STEP;
                }

                if ((startIndex >= 1 && nextStep >= collection.size() - 1) ||
                        (startIndex >= 1 && nextStep >= collection.size() - 2)){
                    return false;
                }

                return true;
            }

            @Override
            public T next() {
                return collection.get(startIndex + index++ * STEP);
            }
        };
    }
}
