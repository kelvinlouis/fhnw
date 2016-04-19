package ch.fhnw.oop2.assignment02;

/**
 * Created by Kelvin on 17-Mar-16.
 */
public class ArrayBox <T extends ClassA> {
    private ClassA[] arr = new ClassA[5];

    public void add(T val) {
        arr[0] = val;
    }
}
