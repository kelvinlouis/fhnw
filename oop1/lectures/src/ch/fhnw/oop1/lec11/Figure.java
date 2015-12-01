package ch.fhnw.oop1.lec11;

import java.util.Scanner;

/**
 * Created by Kelvin on 01-Dec-15.
 */
public abstract class Figure {
    private int x;
    private int y;

    public abstract double getArea();

    public abstract double getCircumfrence();

    public abstract void createInteractively (Scanner scanner);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
