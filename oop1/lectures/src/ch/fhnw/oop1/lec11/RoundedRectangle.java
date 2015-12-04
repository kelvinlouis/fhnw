package ch.fhnw.oop1.lec11;

/**
 * Created by Kelvin on 04-Dec-15.
 */
public class RoundedRectangle extends Rectangle {
    private double cornerRadius = 0;

    public RoundedRectangle(double height, double width, double cr) {
        super(height, width);
        cornerRadius = cr;
    }

    public RoundedRectangle(double height, double width) {
        super(height, width);
    }

    public RoundedRectangle() {}

    public double getArea() {
        return super.getArea();
    }

    public double getCircumference() {
        return super.getCircumference();
    }

    public void setRadius(double radius) {
        this.cornerRadius = radius;
    }
}