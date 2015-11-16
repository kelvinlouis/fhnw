package ch.fhnw.oop1;
import ch.fhnw.oop1.dogs2.*;

import java.util.Scanner;

/**
 * Created by Kelvin on 10.11.2015.
 */
public class Lecture9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dog doggy = new Dog("Samuel L. Jackson", 12);

        askForSize(doggy, scanner);

        //first();
    }

    public static void first() {
        Beagle smallBeagle = Beagle.getSmallOne("Name");
        Dog doggy = new Dog("Kelvin", 12);

        try {
            doggy.setSize(-12);
        } catch(Exception e) {
            //System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    public static void askForSize(Dog doggy, Scanner scanner) {
        int size;

        try {
            System.out.printf("%nNeue Grösse für %s angeben: ", doggy.getName());
            size = scanner.nextInt();
            doggy.setSize(size);
        } catch (Exception e) {
            askForSize(doggy, scanner);
        }
    }
}
