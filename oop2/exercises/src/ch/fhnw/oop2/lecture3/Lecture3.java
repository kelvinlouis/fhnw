package ch.fhnw.oop2.lecture3;

import ch.fhnw.oop2.lecture2.Beer;
import ch.fhnw.oop2.lecture2.Bottle;
import ch.fhnw.oop2.lecture2.Drink;
import ch.fhnw.oop2.lecture2.Wine;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

/**
 * Created by Kelvin on 08-Mar-16.
 */
public class Lecture3 {
    public static void main(String[] args) {
        Bottle<Beer> beerBottle = new Bottle<>();
        Bottle<Wine> wineBottle = new Bottle<>();

        List<Bottle<Beer>> list = new ArrayList<>();
        list.add(beerBottle);

        refillBottlesType(list, new Beer());
        refillBottlesWildcard(list, new Wine());

        for (Bottle b: list) {
            System.out.println(b.empty());
        }

        // Lambdas
        exerciseImages("C:\\Users\\Kelvin\\Pictures\\chiefkeef");
        exerciseLambdas();
        exerciseDefault();
    }

    public static <T extends Drink> void emptyBottlesType(List<Bottle<T>> bottles) {
        for(Bottle b: bottles) {
            b.empty();
        }
    }

    public static void emptyBottlesWildcard(List<Bottle<? extends Drink>> bottles) {
        for (Bottle b: bottles) {
            b.empty();
        }
    }

    public static void refillBottlesWildcard(List<? extends Bottle<? extends Drink>> bottles, Drink content) {
        for (Bottle b: bottles) {
            b.empty();
            b.fill(content);
        }
    }

    public static <T extends Drink> void refillBottlesType(List<Bottle <T>> bottles, T content) {
        for (Bottle b: bottles) {
            b.empty();
            b.fill(content);
        }
    }

    public static void exerciseImages(String path) {
        File dir = new File("C:\\Users\\Kelvin\\Pictures\\chiefkeef");
        File[] arr = dir.listFiles((File pathname) ->
            pathname.isFile() && !pathname.toString().endsWith(".png"));

        for (File f: arr) {
            System.out.println(f);
        }
    }

    public static void exerciseLambdas() {
       ArrayList<String> strings = new ArrayList<>();
        strings.add("Blupp");
        strings.add("Blap");
        strings.add("LALALALALALA");

        strings.forEach(s -> {
            if (s.length() > 10)
                System.out.println(s);
        });

        strings.removeIf(s -> s.length() > 10);

        strings.forEach(System.out::println);
    }

    public static void exerciseDefault() {
        KelvinLouisJunior junior = new KelvinLouisJunior();

        System.out.println(junior.add(5,2));
    }
}

//    Function<String, Integer> stringToInteger
//            = Integer::parseInt;
//    BiPredicate<List<String>, String> contains
//            = List::contains