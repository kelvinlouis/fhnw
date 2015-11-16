package ch.fhnw.oop1;

import ch.fhnw.oop1.dogs.*;

/**
 * Created by Kelvin on 20.10.2015.
 */
public class OverloadingTest {

    public static void doIt(Dog dog) {
        System.out.printf("doIt(Dog dog)%n");
    }

    public static void doIt(Beagle beagle) {
        System.out.printf("doit(Beagle beagle)%n");
    }

    public static void main(String[] args) {
        Dog dog = new Dog("Hund", 40);
        doIt(dog);

        Beagle beagle = new Beagle("Jacky");
        doIt(beagle);

        dog = beagle;
        doIt(dog);
    }
}
