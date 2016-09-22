package problem1;
import java.util.List;

public class ListyIterator<T> {

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

}
