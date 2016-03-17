package ch.fhnw.algd1.assignment02;

/**
 * Created by Kelvin on 06-Mar-16.
 */
public class Assignment2 {
    public static void main(String[] args) {

        // 1d
        double d = -+-010.d;
        int i = -+-+-+-010;
        System.out.println(d);
        System.out.println(i);

        // 2a
        double m = 0b11110%11;
        System.out.println(m);

        // 2b
        //double x2b = (1/5)/0 - (1.5)/0;
        System.out.println(1/5);

        // 2c
        double x2c = (.5 - .5f)/0.;
        System.out.println(x2c);

        // 2d
        double x2d = (0.1 - 0.1f)/0.;
        System.out.println(x2d);
        System.out.println(0.1d - 0.1f);

        // 2e
        int x2e = Integer.MIN_VALUE;
        System.out.println((char) -x2e);
        System.out.println((char) (Math.pow(2,15)+1));

        //int x2f = 070 / (Integer.MIN_VALUE- -Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE);

        // 2g
        //int x2g = 0xabc / (071 - 57);
        // division by zeero

        // 2h
        boolean x2h = -9 % 2 == -3 % -2;
        System.out.println(x2h);

        // 2i
        int x = 5;
        System.out.println(++x << x < x || x > x >> x++);
    }
}
