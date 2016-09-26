package ch.fhnw.oop1.assignment09;

import java.util.Scanner;

/**
 * Created by Kelvin on 22.11.2015.
 */
public class Assignment09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cinema cinema = new Cinema();

        while (true) {
            System.out.print("Book (b row seat) / Cancel (c row seat) / Quit (q):\t");
            String entry = scanner.nextLine();

            System.out.print("\n\n");

            String[] parts = entry.split(" ");
            String action = parts[0];

            if (action.equals("q")) break;

            int row = Integer.parseInt(parts[1]);
            int seat = Integer.parseInt(parts[2]);

            if (action.equals("b")) {
                cinema.book(row, seat);
            } else if (action.equals("c")) {
                cinema.cancel(row, seat);
            }

            cinema.showSeatTable();
            System.out.printf("\n");
        }
    }
}
