package ch.fhnw.oop1.lec14.material;

/**
 * Created by Kelvin on 05-Jan-16.
 */
public class Sphere extends Body {
    private int radius;

    public Sphere(int radius, Enum mat) {
        super(mat);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
