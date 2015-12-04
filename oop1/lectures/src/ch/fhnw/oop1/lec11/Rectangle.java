package ch.fhnw.oop1.lec11;

import java.util.Scanner;

/**
 * Created by Kelvin on 01-Dec-15.
 */
public class Rectangle extends Figure {
    protected double height = 0;
    protected double width = 0;

    public Rectangle(double height, double width) {
        setHeight(height);
        setWidth(width);
    }

    public Rectangle() {}

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getCircumference() {
        return 2 * (height + width);
    }

    @Override
    public void createInteractively(Scanner scanner) {
        System.out.print("Height: ");
        height = scanner.nextDouble();

        System.out.printf("Width: ");
        width = scanner.nextDouble();
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
}
