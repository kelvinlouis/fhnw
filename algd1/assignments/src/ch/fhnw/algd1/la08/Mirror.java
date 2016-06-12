package ch.fhnw.algd1.la08;

import java.io.IOException;

/**
 * Created by Kelvin on 31-May-16.
 */
public class Mirror {
    public static void main(String[] args) throws IOException {
        System.out.print("Eingabe: ");
        Mirror.read();
    }

    static public void read() throws IOException {
        int x = System.in.read();
        if (x == '\n') {
            System.out.print("Ausgabe: ");
            return;
        }
        read();
        System.out.print((char) x);
    }
}
