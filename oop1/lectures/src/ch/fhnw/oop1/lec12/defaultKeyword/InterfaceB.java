package ch.fhnw.oop1.lec12.defaultKeyword;

/**
 * Created by Kelvin on 08-Dec-15.
 */
public interface InterfaceB {
    default void sayHi() {
        System.out.println("Hoi");
    }
}
