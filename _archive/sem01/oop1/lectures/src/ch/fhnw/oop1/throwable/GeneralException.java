package ch.fhnw.oop1.throwable;

/**
 * Created by Kelvin on 10.11.2015.
 */
public class GeneralException extends Exception {
    public GeneralException() {
        super();
    }

    public GeneralException(String message) {
        super(message);
    }

    public GeneralException(Throwable cause) {
    }
}
