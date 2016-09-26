package ch.fhnw.oop2.testPrep.compare;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Kelvin on 05-Jul-16.
 */
public class CompareExample {
    public static void main(String[] args) {
        List<Developer> listDevs = getDevelopers();

        // Use Collections.sort with Comparator
        Collections.sort(listDevs, new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        // Needs to implement Comparable to just sort a list.
        //Collections.sort(listDevs);

        // New way to sort using lambdas
        listDevs.sort((Developer o1, Developer o2) -> o1.getAge() - o2.getAge());

        // Without types
        listDevs.sort((o1, o2) -> o1.getAge() - o2.getAge());

        // Sort names
        listDevs.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));

        // Create a variable for comparator using lambdas
        Comparator<Developer> salaryComparator = (o1, o2) -> o1.getSalary().compareTo(o2.getSalary() );
        listDevs.sort(salaryComparator);
    }


    private static List<Developer> getDevelopers() {

        List<Developer> result = new ArrayList<>();

        result.add(new Developer("mkyong", new BigDecimal("70000"), 33));
        result.add(new Developer("alvin", new BigDecimal("80000"), 20));
        result.add(new Developer("jason", new BigDecimal("100000"), 10));
        result.add(new Developer("iris", new BigDecimal("170000"), 55));

        return result;

    }
}
