package ch.fhnw.oop1.lec11;

import java.util.Scanner;

/**
 * Created by Kelvin on 01-Dec-15.
 */
public class Circle extends Figure {
    private double radius = 0;

    public Circle(double radius) {
        setRadius(radius);
    }

    public Circle() {}

    @Override
    public void createInteractively(Scanner scanner) {
        System.out.print("Radius: ");
        radius = scanner.nextDouble();
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getCircumfrence() {
        return 2 * Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws IllegalArgumentException {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius has to be at least 0");
        }
        this.radius = radius;
    }
}
