package ch.fhnw.oop1.lec11;

import java.util.Scanner;

/**
 * Created by Kelvin on 04-Dec-15.
 */
public class RoundedRectangle extends Rectangle {
    private double cornerRadius = 0;

    private final double φ = Math.PI / 2; // 90deg

    public RoundedRectangle(double height, double width, double cr) {
        super(height, width);
        setRadius(cr);
    }

    public RoundedRectangle(double height, double width) {
        super(height, width);
    }

    public RoundedRectangle() {}

    /**
     * Created formula by hand and using Papula Formula (Page 32: Circular Sector)
     * 2(rw-2(r^2))+2(hr-2(r^2))+(hw-2rw-2hr+4(r^2))+4((1/2)*(r^2)*φ)
     * hw-4(r^2)+2φ(r^2)
     * 2*(r^2)*(φ-2)+hw
     */
    public double getArea() {
        double w = width;
        double h = height;
        double r = cornerRadius;

        return 2*r*r*(φ-2)+(h*w);
    }

    /**
     * Created formula by hand and using Papula Formula (Page 32: Circular Sector)
     * 2(w-2r)+2(h-2r)+4rφ
     * 2w-8r+2h+4rφ
     * 2(w-4r+h+2rφ)
     * 2(w+h+2r(φ-2))
     */
    public double getCircumference() {
        double w = width;
        double h = height;
        double r = cornerRadius;

        return 2*(w+h+2*r*(φ-2));
    }

    public void createInteractively(Scanner scanner) {
        super.createInteractively(scanner);

        System.out.printf("Radius: ");
        setRadius(scanner.nextDouble());
    }

    public void setRadius(double radius) throws IllegalArgumentException {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius has to be at least 0");
        }

        this.cornerRadius = radius;
    }

    public double getRadius() {
        return cornerRadius;
    }
}
