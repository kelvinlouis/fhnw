package ch.fhnw.oop2.lecture4;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Kelvin on 15-Mar-16.
 */
public class Lecture4 {
    public static void main(String[] args) {
        streamsExercise1();
        System.out.println("+++++++++++++++++++++++++");
        streamsExercise2();
        System.out.println("+++++++++++++++++++++++++");
        streamsExercise3();
        System.out.println("+++++++++++++++++++++++++");
        streamsExercise4();
        System.out.println("+++++++++++++++++++++++++");
        streamsExercise5();
        System.out.println("+++++++++++++++++++++++++");
        streamsExercise6();
        System.out.println("+++++++++++++++++++++++++");
        streamsExercise7();
    }

    public static void lambda() {
        List<String> cities = new ArrayList<>(Arrays.asList(
                "Bern", "Basel", "Aarau", "Zürich",
                "Lugano", "Locarno", "Ascona", "Winterthur",
                "St. Gallen"));

        cities.removeIf(city -> !(city.charAt(0) == 'A' || city.charAt(0) == 'B'));
        cities.sort((x, y) -> (y.compareTo(x)));
        cities.forEach(System.out::println);

        List lengths = new ArrayList<>(cities);
        lengths.replaceAll( x -> ((String) x).length());
        lengths.forEach(System.out::println);
    }

    public static void streams() {
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8).stream()
            .filter(n -> {
                System.out.println("filtering " + n);
                return n % 2 == 0;
            })
            .map(n -> {
                System.out.println("mapping " + n);
                return n * n;
            })
            .limit(2)
            .forEach(System.out::println);
    }

    public static void streamsExercise1() {
        List<String> cities = Arrays.asList(
                "Bern", "Basel", "Aarau", "Zürich",
                "Lugano", "Locarno", "Ascona", "Winterthur",
                "St. Gallen");

        cities.stream()
                .filter(x -> x.startsWith("L"))
                .forEach(System.out::println);
    }

    public static void streamsExercise2() {
        List<String> cities = Arrays.asList(
                "Bern", "Basel", "Aarau", "Zürich",
                "Lugano", "Locarno", "Ascona", "Winterthur",
                "St. Gallen");

        cities.stream()
                .sorted((x,y) -> Integer.compare(x.length(), y.length()))
                .map( x -> new StringBuilder(x).reverse())
                .forEach(System.out::println);

        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println(cities.stream().max( (x, y) -> x.length() > y.length() ? 1 : -1).get());
        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println(cities.stream().min((x, y) -> x.length() - y.length()).get());
        System.out.println("++++++++++++++++++++++++++++++++++");
        cities.stream().limit(4).forEach(System.out::println);
        System.out.println("++++++++++++++++++++++++++++++++++");
        cities.stream().skip(cities.size() - 3).forEach(System.out::println);
        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println(cities.stream().count() == 0);
        System.out.println("++++++++++++++++++++++++++++++++++");
        List li = cities.stream().collect(Collectors.toList());
        Map ma = cities.stream().collect(Collectors.toMap(t -> t, t -> t ));
        Set se = cities.stream().collect(Collectors.toSet());
    }

    public static void streamsExercise3() {
        Stream stream = Stream.of("Java", "8", "is great");
        System.out.println(stream.collect(Collectors.joining(".")).toString());
    }

    public static void streamsExercise4() {
        int[] primes = {2, 3, 5, 7, 11, 13};

        System.out.println(Arrays.stream(primes).sum());
    }

    public static void streamsExercise5() {
        System.out.println(Stream.iterate(2, f -> f + 2)
                .limit(99)
                .mapToInt(Integer::intValue)
                .sum());
    }

    public static void streamsExercise6() {
        Stream.generate(() -> (int) (10*Math.random()))
                .limit(20)
                .forEach(System.out::println);
    }

    public static void streamsExercise7() {
        IntStream.iterate(1, i -> i + 1).limit(5).forEach(System.out::println);
    }
}
