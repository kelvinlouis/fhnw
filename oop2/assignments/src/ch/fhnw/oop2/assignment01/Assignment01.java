package ch.fhnw.oop2.assignment01;

import java.util.*;

/**
 * Created by Kelvin on 26-Feb-16.
 */
public class Assignment01 {
    public static void main(String[] args) {
        // Persons
        Person kelvin = new Person("Kelvin", "Louis", "33-333-3333");
        Person nicola = new Person("Nicola", "Cocquio", "22-222-2222");
        Person haisi = new Person("Hasan", "Kara", "11-111-1111");
        Person jalil = new Person("Jalil", "Hashemi", "44-444-4444");
        Person tom = new Person("Tom", "Brady", "00-000-0000");

        Person[] persons = new Person[] { kelvin, nicola, haisi, jalil, tom };

        ArrayList list = new ArrayList();
        HashSet<Person> set = new HashSet();
        TreeMap<String,Person> map = new TreeMap<>();
        HashMap<String,Person> hashMap = new HashMap<>();

        // Popupate data structures
        for (Person person: persons) {
            list.add(person);
            set.add(person);
            map.put(person.getEnrolmentNumber(), person);
            hashMap.put(person.getEnrolmentNumber(), person);
        }

        System.out.println("ArrayList:");
        for (Object person: list) {
            System.out.println(person);
        }
        System.out.println("==================================");

        System.out.println("HashSet:");
        for (Person person: set) {
            System.out.println(person);
        }
        System.out.println("==================================");

        System.out.println("TreeMap:");
        for (Person person: map.values()) {
            System.out.println(person);
        }
        System.out.println("==================================");

        System.out.println("HashMap:");
        for (Person person: hashMap.values()) {
            System.out.println(person);
        }
        System.out.println("==================================");
    }
}
