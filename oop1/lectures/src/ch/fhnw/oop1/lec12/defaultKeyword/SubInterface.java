package ch.fhnw.oop1.lec12.defaultKeyword;

/**
 * Created by Kelvin on 08-Dec-15.
 */
public interface SubInterface extends InterfaceA, InterfaceB {
    @Override
    default void sayHi() {
        InterfaceB.super.sayHi();
    }

    static void aaa() {
        InterfaceA.aaa();
    }
}
