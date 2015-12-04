package ch.fhnw.oop1.lec11;

import java.util.Scanner;

/**
 * Created by Kelvin on 01-Dec-15.
 */
public class Rectangle extends Figure {
    private double height = 0;
    private double width = 0;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public Rectangle() {}

    @Override
    public void createInteractively(Scanner scanner) {
        System.out.print("Height: ");
        height = scanner.nextDouble();

        System.out.printf("Width: ");
        width = scanner.nextDouble();
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getCircumfrence() {
        return 2 * (height + width);
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
