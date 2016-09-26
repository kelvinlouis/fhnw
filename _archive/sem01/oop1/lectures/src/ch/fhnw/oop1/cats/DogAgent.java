package ch.fhnw.oop1.cats;

import ch.fhnw.oop1.dogs2.Dog;

/**
 * Created by Kelvin on 03.11.2015.
 */
public class DogAgent extends Dog {
    public DogAgent(String name) {
        super(name, 30);

        System.out.println(Dog.puppyFaceSecret);
    }
}
