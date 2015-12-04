package ch.fhnw.oop1.lec11;

import java.util.Scanner;

/**
 * Created by Kelvin on 01-Dec-15.
 */
public class Geometry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Figure fig;
            String what = "";

            System.out.print("What do you want to create? (Circle, Rectangle, Nothing)\t");
            what = scanner.next();

            if (what.equals("Circle")) {
                fig = new Circle();
                fig.createInteractively(scanner);
            } else if (what.equals("Rectangle")) {
                fig = new Rectangle();
                fig.createInteractively(scanner);
            } else {
                break;
            }

            // todo: check how to use double in printf
            System.out.printf("Area is: %d %n", (int) fig.getArea());
            System.out.printf("Circumference is: %d %n", (int) fig.getCircumference());
            System.out.println("");
        }
    }
}
