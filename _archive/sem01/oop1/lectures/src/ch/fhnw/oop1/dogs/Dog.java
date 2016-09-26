package ch.fhnw.oop1.dogs;

/**
 * Created by Kelvin on 20.10.2015.
 */
public class Dog {
    private String name;
    private int size;

    public Dog(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public void bark() {
        System.out.println("Woof");
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
