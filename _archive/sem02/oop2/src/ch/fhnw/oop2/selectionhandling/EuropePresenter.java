package ch.fhnw.oop2.selectionhandling;

import ch.fhnw.oop2.selectionhandling.model.Country;
import ch.fhnw.oop2.selectionhandling.model.EuropeModel;
import ch.fhnw.oop2.selectionhandling.model.embedded.EmbeddedEuropeModel;
import ch.fhnw.oop2.selectionhandling.view.EuropeView;
import ch.fhnw.oop2.selectionhandling.view.SelectedCountryProxy;

import java.util.ResourceBundle;

/**
 * the presenter of the Europe app
 */
public class EuropePresenter {

    private final ResourceBundle STRINGS = ResourceBundle.getBundle(
            "ch.fhnw.oop2.selectionhandling.view.javafx.Strings");

    private final EuropeView view;
    private final EuropeModel model;

    /**
     * creates a new EuropePresenter
     *
     * @param view the current view of the Europe app
     */
    public EuropePresenter(EuropeView view) {
        this.view = view;
        model = new EmbeddedEuropeModel();
    }

    /**
     * fills the current view with the data from the model
     */
    public void fillView() {
        view.setEurope(model.getEurope());
    }

    /**
     * sets the name of a country
     *
     * @param country the country
     * @param name the new name
     */
    public void setName(Country country, String name) {
        if (name.equalsIgnoreCase("DDR")) {
            view.showErrorMessage(
                    STRINGS.getString("Invalid_Country"),
                    STRINGS.getString("Country_Assimilated"));
        } else {
            country.setName(name);
        }
        view.changedName(country);
    }

    /**
     * sets the name of a country
     *
     * @param country the country
     * @param area the new area
     */
    public void setArea(Country country, double area) {
        if (country != null) {
            country.setArea(area);
            view.changedArea(country);
        }
    }
}
