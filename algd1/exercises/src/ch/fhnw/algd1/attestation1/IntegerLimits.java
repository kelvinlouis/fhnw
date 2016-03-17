package ch.fhnw.algd1.attestation1;

/**
 * Created by Kelvin on 10-Mar-16.
 */
public class IntegerLimits {
    public static void main(String[] args) {
        int value = 1;

        for (int i = 0; i < 5; i++) {
            value *= 256;
            System.out.println(value);
        }
    }
}
