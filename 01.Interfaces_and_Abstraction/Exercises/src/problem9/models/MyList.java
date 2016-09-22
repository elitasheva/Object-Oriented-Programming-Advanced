package problem9.models;


import problem9.interfaces.Used;

public class MyList extends AddRemoveCollection implements Used {

    private int index;

    public MyList() {
        super();
        this.index = 0;
    }

    @Override
    public String remove() {
        return this.strings.remove(index);
    }

    @Override
    public int used() {
        return this.strings.size();
    }
}
