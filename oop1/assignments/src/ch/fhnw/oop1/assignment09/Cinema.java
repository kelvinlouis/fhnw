package ch.fhnw.oop1.assignment09;

public class Cinema {
    private final int ROWS = 5;
    private final int SEATS = 10;

    private Seat[][] seats = new Seat[ROWS][SEATS];

    public Cinema() {
        // Populate array
        for (int row = 0; row < seats.length; row++) {
            for (int i = 0; i < seats[row].length; i++) {
                seats[row][i] = new Seat();
            }
        }
    }

    public void book(int row, int seat) {
        try {
            this.validateSeatExistence(row, seat);

            // Adjust for array
            seats[row - 1][seat - 1].book();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (SeatStateException e) {
            System.out.printf("(%d/%d) %s%n", row, seat, e.getMessage());
        }
    }

    public void cancel(int row, int seat) {
        try {
            this.validateSeatExistence(row, seat);

            // Adjust for array
            seats[row - 1][row - 1].cancel();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (SeatStateException e) {
            System.out.printf("(%d/%d) %s%n", row, seat, e.getMessage());
        }
    }

    public void showSeatTable() {
        // Numerate number of seats
        System.out.print("  \t");

        for (int i = 0; i < SEATS; i++) {
            System.out.printf(" %d ", i+1);
        }

        System.out.println("");

        for (int row = 0; row < seats.length; row++) {
            // Numerate each row
            System.out.printf("%d\t", row+1);

            for (Seat seat: seats[row]) {
                System.out.printf("[%s]", seat.getBooked() ? "X" : " ");
            }

            System.out.println("");
        }
    }

    private void validateSeatExistence(int row, int seat) throws IllegalArgumentException {
        if (row < 1 || row > ROWS) {
            throw new IllegalArgumentException("Row #" + row + " doesn't exist");
        }

        if (seat < 1 || seat > SEATS) {
            throw new IllegalArgumentException("Seat #" + seat + " doesn't exist");
        }
    }
}