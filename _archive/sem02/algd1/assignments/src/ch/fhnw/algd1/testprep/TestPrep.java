package ch.fhnw.algd1.testprep;

/**
 * Created by Kelvin on 16-May-16.
 */
public class TestPrep {
    public static void main(String[] args) {
        double m = 0b11110%11;
        double e = (.5 - .5f) /0;
        double f = (0.2 - 0.2f)/0.;
        double dd = 1.0 / 0.;

        int x = 4;

        System.out.println(--x << x < x | x > x >> x--);

        short s = 8;

        System.out.println(s-- + " " + s-- + " " + s);

        System.out.println(m);
        System.out.println(e);
        System.out.println(f);
        System.out.println(dd);
        System.out.println(1.0/-0);
        System.out.println((byte) 1432);
        System.out.println(5 % -2);
    }
}
