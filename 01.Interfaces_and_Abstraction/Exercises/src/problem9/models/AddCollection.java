package problem9.models;

import problem9.interfaces.Add;

import java.util.LinkedList;
import java.util.List;

public class AddCollection implements Add {

    protected List<String> strings;
    protected int index;

    public AddCollection() {
        this.strings = new LinkedList<>();
        this.index = 0;
    }

    @Override
    public int add(String item) {
        this.strings.add(index,item);
        return index++;
    }
}
