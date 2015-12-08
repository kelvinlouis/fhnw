package ch.fhnw.oop1.lec12.defaultKeyword;

/**
 * Created by Kelvin on 08-Dec-15.
 */
public interface InterfaceA {

    static void aaa() {
        System.out.println("AAA");
    }

    default void sayHi() {
        System.out.println("Hi");
    }
}
