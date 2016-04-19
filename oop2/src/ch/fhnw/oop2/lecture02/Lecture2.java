package ch.fhnw.oop2.lecture2;

import java.util.ArrayList;

/**
 * Created by Kelvin on 01-Mar-16.
 */
public class Lecture2 {
    public static void main(String[] args) {
//        exercise1();
//        exercise2();
//        exercise3();
//        exercise4();
    }

    public static void exercise1() {
        ArrayList list = new ArrayList();

        list.add(42);
        list.add("Kelvin");

        printExercise1(list);
    }

    public static void printExercise1(ArrayList list) {
        for (Object item: list) {
            if (item instanceof Number) {
                System.out.println(item.hashCode());
            } else if (item instanceof String) {
                System.out.println(((String) item).length());
            }
        }
    }

    public static void exercise2() {
        Bottle<Beer> beerBottle = new Bottle<>();

        beerBottle.fill(new Beer());
        System.out.println(beerBottle.empty());
    }

    public static void exercise3() {
        Bottle<Beer> beer = new Bottle<>();
        beer.fill(new Beer());

        Bottle<Wine> wine = new Bottle<>();
        wine.fill(new Wine());

        exercise3Empty(beer, wine);
    }

    public static void exercise3Empty(Bottle<?>... bottles) {
        for (Bottle<?> bottle: bottles) {
            bottle.empty();
        }
    }

    public static <T extends Comparable<T>> int compare(T a, T b) {
        return a.compareTo(b);
    }

    public static void exercise4() {
        Drink drink1 = new Drink();
        Drink drink2 = new Drink();

        Beer beer1 = new Beer();
        Beer beer2 = new Beer();

        compare(drink1, drink2);
        compare(beer1, beer2);

        Wine wine = new Wine();

        compare(beer1, wine);
        compare(beer1, wine);
        compare(new Beer(), new Beer());
    }
}
