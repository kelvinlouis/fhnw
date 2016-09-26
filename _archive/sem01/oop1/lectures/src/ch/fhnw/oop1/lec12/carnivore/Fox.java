package ch.fhnw.oop1.lec12.carnivore;

/**
 * Created by Kelvin on 30-Jan-16.
 */
public class Fox extends Canid implements Mouser {
    @Override
    public void catchMouse() {
        System.out.println("Fox catches mouse");
    }
}
