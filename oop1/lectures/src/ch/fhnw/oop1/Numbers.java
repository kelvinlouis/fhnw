package ch.fhnw.oop1;

/**
 * Created by Kelvin on 03.11.2015.
 */
public class Numbers {
    public static int[] numbers0To99;

    // Klasseninitialisierer
    static {
        numbers0To99 = new int[100];

        for(int i = 0; i < numbers0To99.length; i++) {
            numbers0To99[i] = i;
        }
    }
}
