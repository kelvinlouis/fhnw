package ch.fhnw.oop2.starwars;

import java.util.List;

/**
 * the view of the application
 */
public interface ApplicationView {

    /**
     * sets the list of Star Wars movies
     *
     * @param movies the list of Star Wars movies
     */
    public void setStarWarsMovies(List<String> movies);
}
