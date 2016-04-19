package ch.fhnw.oop2.lecture1;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Kelvin on 23-Feb-16.
 */
public class Lecture1 {
    public static void main(String[] args) {
        TreeSet ts = new TreeSet();

        ts.add("tom");
        ts.add("brady");
        ts.add("bill");

        System.out.println(ts.size());

        ts.add("tom");
        ts.add("brady");
        ts.add("bill");

        System.out.println(ts.size());
    }
}
