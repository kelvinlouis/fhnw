package ch.fhnw.oop1.lec12.carnivore;

/**
 * Created by Kelvin on 30-Jan-16.
 */
public class Dog extends Canid implements Strokable {
    @Override
    public void stroke() {
        System.out.println("Dog being stroked");
    }
}
