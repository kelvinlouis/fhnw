package ch.fhnw.oop1.exam14;

/**
 * Created by Kelvin on 30-Jan-16.
 */
public abstract class Material {
    private double density;
    private String description;

    public Material(double den, String des) {
        density = den;
        description = des;
    }

    public String toString() {
        return description + " with " + density + " g/cm3";
    }

    public abstract void print();

    public boolean equals(Object o) {
        if (o instanceof Material) {
            Material m = (Material) o;
            return density == m.density && description.equals(((Material) o).description);
        }
        return false;
    }

    public double getDensity() {
        return density;
    }
}
