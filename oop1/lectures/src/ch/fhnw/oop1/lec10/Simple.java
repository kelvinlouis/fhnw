package ch.fhnw.oop1.lec10;

/**
 * Created by Kelvin on 17.11.2015.
 */
public class Simple {
    public int getIndex(char letter) {
       return letter < 'a' ? letter - 'A' : letter - 'a';
    }

    public char indexToChar(int index) {
        if (index < 0 || index > ('z' - 'a')) {
            throw new IllegalArgumentException("Argument has to be between 0 and 25");
        }

        return (char) (index + 'a');
    }
}
