package problem1.models;

public class Box<P extends Comparable<P>> implements Comparable<Box<P>>{

    private P value;

    public Box(P value) {
        this.value = value;
    }

    public P getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.value.getClass().getName(), this.value);
    }


    @Override
    public int compareTo(Box<P> other) {
        return this.getValue().compareTo(other.getValue());
    }
}
