package ch.fhnw.oop1.lec12.carnivore;

import ch.fhnw.oop1.lec12.Strokable;

/**
 * Created by Kelvin on 08-Dec-15.
 */
public class Dog extends Canid implements Strokable {

    @Override
    public void stroke() {
        System.out.println("Dog being stroked");
    }
}
