package problem9.models;

import problem9.interfaces.Remove;

public class AddRemoveCollection extends AddCollection implements Remove{

    private int index;

    public AddRemoveCollection() {
        super();
        this.index = 0;
    }

    @Override
    public int add(String item) {
        this.strings.add(index,item);
        return index;
    }

    @Override
    public String remove() {
        int lastIndex = this.strings.size() - 1;
        return this.strings.remove(lastIndex);
    }
}
