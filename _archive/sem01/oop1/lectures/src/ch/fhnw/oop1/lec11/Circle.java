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
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void createInteractively(Scanner scanner) {
        System.out.print("Radius: ");
        setRadius(scanner.nextDouble());
    }

    public void setRadius(double radius) throws IllegalArgumentException {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius has to be at least 0");
        }
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
