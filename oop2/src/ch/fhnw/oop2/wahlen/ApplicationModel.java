package ch.fhnw.oop2.wahlen;

import java.util.List;

/**
 * the model of the application
 */
public interface ApplicationModel {

    /**
     * returns the application data
     *
     * @return the application data
     */
    public List<Result> getData();
}
