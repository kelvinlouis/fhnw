package ch.fhnw.oop1.lec14.canton;

/**
 * Created by Kelvin on 05-Jan-16.
 */
public enum Canton {

    ZURICH(1_000_000, 87.88), BASEL(165_000, 23.91);

    private double population;

    private double area;

    Canton(double pop, double size) {
        this.population = pop;
        this.area = size;
    }
}
