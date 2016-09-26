package ch.fhnw.oop1;

import java.util.Arrays;
import ch.fhnw.oop1.dogs2.*;

/**
 * Created by Kelvin on 03.11.2015.
 */
public class Lecture8 {
    public static void main (String[] args) {
        System.out.println(Arrays.toString(Numbers.numbers0To99));

        dogMayhem();
    }

    private static void dogMayhem() {
        Dog dog1 = new Dog("Hasso", 30);
        Dog dog2 = new Dog(dog1);

        Dog[] dogs = new Dog[] {
                new Dog("Haisi",30),
                new Dog("Hasan", 31),
                new Dog("Hasi", 29)
        };

        Dog[] dogs2 = new Dog[3];
        for(int i = 0; i < dogs.length; i++) {
            dogs2[i] = new Dog(dogs[i]);
        }

        System.out.println(dog1.getName());
        System.out.println(dog2.getName());

        dog2.getName().append(" der zweite");

        System.out.println(dog1.getName());
        System.out.println(dog2.getName());

        System.out.println(dog1.equals(new Dog("Hasso", 30)));
    }
}
