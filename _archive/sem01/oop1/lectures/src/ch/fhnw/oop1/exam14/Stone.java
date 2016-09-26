package ch.fhnw.oop1.exam14;

/**
 * Created by Kelvin on 30-Jan-16.
 */
public class Stone extends Material {
    private double diameter;

    public Stone(double den, String desc, double dia) {
        super(den,desc);
        diameter = dia;
    }

    public boolean equals(Object o) {
        if (o instanceof Stone) {
            Stone s = (Stone) o;

            return super.equals(s) && diameter == s.diameter;
        }

        return false;
    }

    public String toString() {
        return super.toString() + " with diameter " + diameter;
    }

    public void print() {
        System.out.println(this);
    }

    public double getDiameter() {
        return diameter;
    }
}
