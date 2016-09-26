package ch.fhnw.oop1.dogs2;

/**
 * Created by Kelvin on 20.10.2015.
 */
public class Dogge extends Dog {

    public Dogge(String name) {
        super(name, 60);
    }

    @Override
    public void bark() {
        System.out.printf("WUFF!");
    }
}
