package problem10.models;

import problem10.intefaces.Tuple;

public class TupleImpl<TKey, TValue> implements Tuple<TKey,TValue>{

    private TKey key;
    private TValue value;

    public TupleImpl(TKey key, TValue value) {
        this.key = key;
        this.value = value;
    }

    public TKey getKey() {
        return key;
    }

    public TValue getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", this.getKey(), this.getValue());
    }
}
