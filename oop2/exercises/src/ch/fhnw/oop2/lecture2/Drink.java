package ch.fhnw.oop2.lecture2;

/**
 * Created by Kelvin on 01-Mar-16.
 */
public class Drink implements Comparable<Drink> {
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    @Override
    public int compareTo(Drink o) {
        return 0;
    }
}
