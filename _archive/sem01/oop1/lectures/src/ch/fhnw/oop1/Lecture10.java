package ch.fhnw.oop1;

import ch.fhnw.oop1.lec10.*;

/**
 * Created by Kelvin on 17.11.2015.
 */
public class Lecture10 {
    public static void main(String[] args) {
        sqrt(2);
    }

    private static double sqrt (double num) {
        assert num > -1;

        double result = Math.sqrt(num);
        //assert Math.abs()

        return result;
    }
}
