package ch.fhnw.oop1.lec14;
import java.awt.Font

/**
 * Created by Kelvin on 31-Jan-16.
 */
public class Sphere extends Body {
    private int radius;

    public Sphere(int ra, Dryness dr, Hardness ha, Roughness ro) {
        super(dr, ha, ro);
        radius = ra;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int r) {
        radius = r;
    }
}
