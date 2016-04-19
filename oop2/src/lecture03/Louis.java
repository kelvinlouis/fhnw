package ch.fhnw.oop2.lecture3;

/**
 * Created by Kelvin on 08-Mar-16.
 */
public interface Louis {
    default int add (int a, int b) {
        return a + b;
    }
}