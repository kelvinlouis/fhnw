package ch.fhnw.oop1.dogs2;

import java.security.InvalidParameterException;

/**
 * Created by Kelvin on 20.10.2015.
 */
public class Dog {
    protected static String puppyFaceSecret = "Kopf runter, Blick nach oben!";
    private StringBuilder name;
    private int size;

    {
        System.out.println("Class Constructor");
    }

    public Dog(String name, int size) {
        this.name = new StringBuilder(name);
        this.size = size;
    }

    public Dog(Dog original) {
        this.name = new StringBuilder(original.name);
        this.size = original.size;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof Dog) {
            Dog other = (Dog) obj;
            return name.toString().equals(other.name.toString()) && this.size == other.size;
        }
        return false;
    }

    public void bark() {
        System.out.println("Woof");
    }

    public void setSize(int size) throws InvalidParameterException{
        if (size < 0) {
            throw new InvalidParameterException("Size has to be positive");
        } else {
            this.size = size;
        }
    }

    public StringBuilder getName () {
        return name;
    }

    public int getSize() {
        return size;
    }
}
