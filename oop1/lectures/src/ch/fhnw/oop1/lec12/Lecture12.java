package ch.fhnw.oop1.lec12;

import ch.fhnw.oop1.lec12.carnivore.*;

/**
 * Created by Kelvin on 08-Dec-15.
 */
public class Lecture12 {
    public static void main(String[] args) {
        Child max = new Child();
        Strokable bob = new Dog();
        Strokable felix = new Cat();
        Strokable ted = new TeddyBear();


        max.stroke(bob);
        max.stroke(felix);
        max.stroke(ted);

        DeepKnight robert = new DeepKnight();
        System.out.println(robert);
    }
}
