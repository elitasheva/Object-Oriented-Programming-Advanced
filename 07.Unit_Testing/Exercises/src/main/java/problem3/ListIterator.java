package problem3;

import javax.naming.OperationNotSupportedException;
import java.util.List;

public class ListIterator {

    private List<String> strings;
    private int index;

    public ListIterator(List<String> strings) throws OperationNotSupportedException {
        this.setStrings(strings);
    }

    public boolean move() {
        if (hasNext()) {
            this.index++;
            return true;
        }
        return false;
    }

    public int size(){
        return this.strings.size();
    }

    public boolean hasNext() {
        return this.index < this.strings.size() - 1;
    }

    public String print() throws OperationNotSupportedException {
        if (this.strings.size() == 0){
            throw new OperationNotSupportedException("Invalid Operation!");
        }
        return this.strings.get(this.index);
    }

    private void setStrings(List<String> strings) throws OperationNotSupportedException {
        if (strings.size() == 0) {
            throw new OperationNotSupportedException("Invalid Operation!");
        }
        this.strings = strings;

    }
}
