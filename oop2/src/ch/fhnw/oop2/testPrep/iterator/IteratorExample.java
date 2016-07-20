package ch.fhnw.oop2.testPrep.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Kelvin on 05-Jul-16.
 */
public class IteratorExample {
    public static void main(String[] args) {
        removeItems();
        removeItems2();
        iterable();
    }

    public static void removeItems() {
        List<String> names = new ArrayList<>();
        names.addAll(Arrays.asList("Chief", "Keef", "Quark", "Split"));

        Iterator<String> i = names.iterator();
        while (i.hasNext()) {
            String s = i.next(); // must be called before you can call i.remove()

            // Do more stuff

            if (s.equals("Quark") || s.equals("Split"))
                i.remove();
        }

        names.forEach(System.out::println);
    }

    public static void removeItems2() {
        List<String> names = new ArrayList<>();
        names.addAll(Arrays.asList("Chief", "Keef", "Quark", "Split"));

        names.removeIf(s -> s.equals("Quark") || s.equals("Split"));

        names.forEach(System.out::println);
    }

    public static void iterable() {
        ProfileCollection coll = new ProfileCollection();

        for (Profile profile : coll) {
            System.out.println(profile.toString());
        }
    }
}
