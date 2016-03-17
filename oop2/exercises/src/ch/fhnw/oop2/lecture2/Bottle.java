package ch.fhnw.oop2.lecture2;

/**
 * Created by Kelvin on 01-Mar-16.
 */
public class Bottle<E extends Drink> {
    private E content;

    public void fill(E content) {
        this.content = content;
    }

    public E empty() {
        E oldContent = content;
        content = null;

        return oldContent;
    }

    public boolean isEmpty() {
        return content == null;
    }
}
