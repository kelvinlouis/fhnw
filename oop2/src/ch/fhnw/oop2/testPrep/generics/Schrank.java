package ch.fhnw.oop2.testPrep.generics;

/**
 * Created by Kelvin on 04-Jul-16.
 */
public class Schrank <K> {
    private K k;
    public void add (K k) {
        this.k = k;
    }
    public K getElement() {
        return k;
    }
}
