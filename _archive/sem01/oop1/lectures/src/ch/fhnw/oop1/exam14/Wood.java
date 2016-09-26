package ch.fhnw.oop1.exam14;

/**
 * Created by Kelvin on 30-Jan-16.
 */
public class Wood extends Material {
    private int water;

    public Wood(String des, int wat) {
        super(wat * (0.5/100) + 0.5, des);
        water = wat;
    }

    public String toString() {
        return super.toString() + " with water " + water;
    }

    public void print() {
        System.out.println(this);
    }
}
