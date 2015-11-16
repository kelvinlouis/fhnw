package ch.fhnw.oop1.dogs2;

/**
 * Created by Kelvin on 20.10.2015.
 */
public class Beagle extends Dog {

    private Beagle() {
        super("Standard", 40);
    }

    private Beagle(String name, int size) {
        super(name, size);
    }

    public static Beagle getOne() {
        return new Beagle();
    }

    public static Beagle getSmallOne(String name) {
        return new Beagle(name, 20);
    }

    public static Beagle getLargeOne(String name) {
        return new Beagle(name, 70);
    }

    @Override
    public void bark() {
        System.out.printf("Woof");
    }
}
