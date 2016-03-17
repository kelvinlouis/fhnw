package ch.fhnw.oop2.assignment02;

/**
 * Created by Kelvin on 17-Mar-16.
 */
public class Box<T, Q> {
    private T value;
    private Q key;

    public void setValue(T val) {
        if (isNull(val)) return;
        value = val;
    }

    public T getValue() {
        return value;
    }

    public void setKey(Q k) {
        if (isNull(k)) return;
        key = k;
    }

    public Q getKey() {
        return key;
    }

    public <P> boolean isNull (P val) {
        return (val == null);
    }
}
