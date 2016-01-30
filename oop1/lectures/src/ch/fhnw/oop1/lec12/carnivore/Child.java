package ch.fhnw.oop1.lec12.carnivore;

/**
 * Created by Kelvin on 30-Jan-16.
 */
public class Child {
    public static void main(String[] args) {
        Cat felix = new Cat();
        Dog cosy = new Dog();
        TeddyBear ted = new TeddyBear();

        Child daisy = new Child();

        daisy.strokeSomething(felix);
        daisy.strokeSomething(cosy);
        daisy.strokeSomething(ted);
    }

    public void strokeSomething(Strokable strokee) {
        strokee.stroke();
    }
}
