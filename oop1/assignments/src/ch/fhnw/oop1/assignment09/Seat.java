package ch.fhnw.oop1.assignment09;

/**
 * Created by Kelvin on 22.11.2015.
 */
public class Seat {
    private boolean booked = false;

    public void book() throws SeatStateException {
        if (booked) {
            throw new SeatStateException("Seat already reserved");
        }
        booked = true;
    }

    public void cancel() throws SeatStateException {
        if (!booked) {
            throw new SeatStateException("Seat not booked");
        }
        booked = false;
    }

    public boolean getBooked() {
        return booked;
    }
}
