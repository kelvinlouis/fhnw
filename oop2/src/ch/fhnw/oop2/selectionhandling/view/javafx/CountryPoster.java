package ch.fhnw.oop2.selectionhandling.view.javafx;

import ch.fhnw.oop2.selectionhandling.model.Country;
import ch.fhnw.oop2.selectionhandling.view.SelectedCountryProxy;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Created by Kelvin on 31-May-16.
 */
public class CountryPoster extends VBox {

    private final SelectedCountryProxy selectedCountryProxy;

    private Label countryLabel;
    private Label areaLabel;

    CountryPoster(SelectedCountryProxy proxy) {
        selectedCountryProxy = proxy;

        getStyleClass().addAll("country-poster", "country");

        initializeControls();
        layoutControls();
        addBindings();
    }

    private void initializeControls() {
        countryLabel = new Label();
        areaLabel = new Label();

        countryLabel.getStyleClass().add("country-poster-title");
        areaLabel.getStyleClass().add("country-poster-title");
    }

    private void layoutControls() {
        getChildren().addAll(countryLabel, areaLabel);
    }

    private void addBindings() {
        countryLabel.textProperty().bind(selectedCountryProxy.nameProperty());
        areaLabel.textProperty().bind(selectedCountryProxy.areaProperty().asString());
    }
}
