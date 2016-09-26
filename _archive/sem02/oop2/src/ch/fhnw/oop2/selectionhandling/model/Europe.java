package ch.fhnw.oop2.selectionhandling.model;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * the politcal Europe
 */
public class Europe {

    private final ObservableList<Country> countries;

    /**
     * creates a new instance of Europe
     *
     * @param countries the countries of Europe
     */
    public Europe(List<Country> countries) {
        this.countries = FXCollections.observableArrayList(countries);
    }

    /**
     * returns the list of european countries
     *
     * @return the list of european countries
     */
    public ObservableList<Country> getCountries() {
        return countries;
    }
}
