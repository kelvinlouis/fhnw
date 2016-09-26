package ch.fhnw.oop1;

import ch.fhnw.oop1.dogs.*;

import java.util.Scanner;

/**
 * Created by Kelvin on 20.10.2015.
 */
public class Lecture6 {
    public static void main(String[] args) {
        int[] a1 = {0,1};
        int[] a2 = {0,1};

        Integer number = 12;
        number = number + 1;
        number++;

        System.out.println(number);

        // doesn't work
        //System.out.println(Arrays.deepEquals(a1,a2));

        System.out.println(-1234.5f);
        System.out.printf("%,.1f\n", -1234.5f);

        Integer a = 127;
        Integer b = 127;

        System.out.println(a == b);
        System.out.println(a >= b);

        Dog dog = new Dog("Hundi", 120);
        Dog dogge = new Dogge("Flipper");
        Chihuahua chi = new Chihuahua("Lil");
        Dog beagle = new Beagle("Brie");

        dogge.bark();
        chi.bark();
        beagle.bark();

        // == vergleicht die referenz und nicht den wert...es findet bei integer objekte kein unboxing statt...bei >= hingegen schon
    }
}
