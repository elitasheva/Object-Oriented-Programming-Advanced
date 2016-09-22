package problem11.models;

import problem11.interfaces.Triplet;

public class TripletImpl<T, U, V> implements Triplet<T, U, V>{

    private T firstParam;
    private U secondParam;
    private V thirdParam;

    public TripletImpl(T firstParam, U secondParam, V thirdParam) {
        this.firstParam = firstParam;
        this.secondParam = secondParam;
        this.thirdParam = thirdParam;
    }

    @Override
    public T getFirstParam() {
        return firstParam;
    }

    @Override
    public U getSecondParam() {
        return secondParam;
    }

    @Override
    public V getThirdParam() {
        return thirdParam;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", this.getFirstParam(), this.getSecondParam(), this.getThirdParam());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TripletImpl)) {
            return false;
        }
        TripletImpl<?, ?, ?> p = (TripletImpl<?, ?, ?>) o;
        return this.getFirstParam().equals(p.getFirstParam()) &&
                this.getSecondParam().equals(p.getSecondParam()) &&
                this.getThirdParam().equals(p.getThirdParam());
    }

    private static boolean equals(Object x, Object y) {
        return (x == null && y == null) || (x != null && x.equals(y));
    }

    @Override
    public int hashCode() {
        return (firstParam == null ? 0 : firstParam.hashCode()) ^
                (secondParam == null ? 0 : secondParam.hashCode()) ^
                (thirdParam == null ? 0 : thirdParam.hashCode());
    }

    public static <F, S, T> TripletImpl <F, S, T> create(F f, S s, T t) {
        return new TripletImpl<F, S, T>(f, s, t);
    }
}
