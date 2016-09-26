package ch.fhnw.oop1.lec12.knight;

/**
 * Created by Kelvin on 30-Jan-16.
 */
public interface UltiInti {
    default void sayHi() {
        System.out.println("Hi");
    }

    static void sayHello() {
        System.out.println("Hello");
    }
}
