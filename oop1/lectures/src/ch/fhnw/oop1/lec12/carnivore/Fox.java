package ch.fhnw.oop1.lec12.carnivore;

/**
 * Created by Kelvin on 08-Dec-15.
 */
public class Fox extends Canid implements Mouser {
    @Override
    public void catchMouse() {
        System.out.println("Fox catching mouse");
    }
}
