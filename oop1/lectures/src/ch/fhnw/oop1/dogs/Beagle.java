package ch.fhnw.oop1.dogs;

/**
 * Created by Kelvin on 20.10.2015.
 */
public class Beagle extends Dog {

    public Beagle(String name) {
        super(name, 40);
    }

    @Override
    public void bark() {
        System.out.printf("Woof");
    }
}
