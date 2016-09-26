package ch.fhnw.oop2.selectionhandling.view;

import ch.fhnw.oop2.selectionhandling.model.Country;
import ch.fhnw.oop2.selectionhandling.model.Europe;

/**
 * the view of the europe app
 */
public interface EuropeView {

    /**
     * sets the political Europe
     *
     * @param europe the political Europe
     */
    public void setEurope(Europe europe);

    /**
     * signals that the name of the country changed
     *
     * @param country the country
     */
    public void changedName(Country country);

    /**
     * signals that the area of the country changed
     *
     * @param country the country
     */
    public void changedArea(Country country);

    /**
     * shows an error message
     *
     * @param headerText the header text of the error message
     * @param contentText the content text of the error message
     */
    public void showErrorMessage(String headerText, String contentText);
}
