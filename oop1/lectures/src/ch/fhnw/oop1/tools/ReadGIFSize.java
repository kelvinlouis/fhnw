package ch.fhnw.oop1.tools;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Kelvin on 10.11.2015.
 */
import ch.fhnw.oop1.throwable.GeneralException;

public class ReadGIFSize {
    public static void main(String[] args) throws GeneralException{
        String path = "C:\\Users\\Kelvin\\fhnw\\oop1\\lectures\\src\\ch\\fhnw\\oop1\\chiefkeef.gif";

        try (RandomAccessFile file = new RandomAccessFile(path, "r")) {
            file.seek(6);

            int width = file.read() + file.read() * 256;
            int height = file.read() + file.read() * 256;

            file.close();

            System.out.printf("%s x %s Pixel%n", width, height);
        } catch (FileNotFoundException e) {
            System.out.printf("%s: %s%n", "File Not Found", e.getMessage());
        } catch (IOException | OutOfMemoryError e) {
            System.out.printf("%s: %s%n", "Cannot Read", e.getMessage());
            throw new GeneralException(e);
        }
    }
}
