package ch.fhnw.oop1.exam14;

/**
 * Created by Kelvin on 30-Jan-16.
 */
public class Ex1 {
    public static void main(String[] args) {
        Stone kies = new Stone(1.9, "Granit", 1.2);
        Material sand = new Stone(1.9, "Granit", 0.1);
        System.out.println(sand.equals(kies)); // false
        kies.print(); //Granit mit 1.9 g/cm3 mit Druchmesser 1.2
        System.out.println(kies.toString());

        Wood h1 = new Wood("Buche", 20);
        Wood h2 = new Wood("Buche", 50);
        h1.print();
        System.out.println(h1.toString());
        h2.print();
        System.out.println(h2.toString());
    }
}
