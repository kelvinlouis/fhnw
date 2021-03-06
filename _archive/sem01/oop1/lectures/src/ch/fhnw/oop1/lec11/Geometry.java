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
            String type;

            System.out.print("What do you want to create (Circle, Rectangle, RoundedRectangle)?\t");
            type = scanner.next();

            try {
                fig = FigureFactory.create(type);
                fig.createInteractively(scanner);
            } catch (IllegalArgumentException err) {
                System.out.println(err.getMessage());
                break;
            }


            System.out.printf("Area is: %f %n", fig.getArea());
            System.out.printf("Circumference is: %f %n", fig.getCircumference());
            System.out.println("");
        }
    }
}
