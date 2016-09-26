package ch.fhnw.oop1.dogs;

/**
 * Created by Kelvin on 20.10.2015.
 */
public class Chihuahua extends Dog {

    public Chihuahua(String name) {
        super(name, 15);
    }

    @Override
    public void bark() {
        System.out.printf("woof");
    }

    public void showOff() {
        super.bark();
    }
}
