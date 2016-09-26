package ch.fhnw.oop1.lec12.carnivore;

/**
 * Created by Kelvin on 30-Jan-16.
 */
public class Cat extends Felid implements Strokable, Mouser {
    @Override
    public void stroke() {
        System.out.println("Cat being stroked");
    }

    @Override
    public void catchMouse() {
        System.out.println("Cat catches mouse");
    }
}
