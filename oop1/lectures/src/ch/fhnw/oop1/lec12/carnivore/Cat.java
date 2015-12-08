package ch.fhnw.oop1.lec12.carnivore;

import ch.fhnw.oop1.lec12.Strokable;

/**
 * Created by Kelvin on 08-Dec-15.
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
