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

        print("ArrayList", list.iterator());
        print("HashSet", set.iterator());
        print("HashMap", hashMap.values().iterator());
        print("TreeMap", map.values().iterator());
    }

    public static void print(String name, Iterator it) {
        System.out.println(name);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("==================================");
    }
}
