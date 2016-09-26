package ch.fhnw.oop2.wahlen;

import java.util.List;

/**
 * the view of the application
 */
public interface ApplicationView {

    /**
     * sets the list of election results
     *
     * @param results the list of election results
     */
    public void setResults(List<Result> results);
}
