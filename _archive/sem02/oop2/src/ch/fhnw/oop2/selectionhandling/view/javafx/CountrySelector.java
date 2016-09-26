package ch.fhnw.oop2.selectionhandling.view.javafx;

import ch.fhnw.oop2.selectionhandling.model.Country;
import ch.fhnw.oop2.selectionhandling.model.Europe;
import ch.fhnw.oop2.selectionhandling.view.SelectedCountryProxy;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.util.converter.NumberStringConverter;

/**
 * a JavaFX user interface for selecting a country
 */
public class CountrySelector extends HBox {

    private final ObjectProperty<Country> selectedCountry;
    private final SelectedCountryProxy selectedCountryProxy;

    private Europe europe;
    private Slider slider;
    private TextField textField;

    /**
     * creates a new CountrySelector
     */
    public CountrySelector(SelectedCountryProxy proxy) {
        this.selectedCountry = new SimpleObjectProperty<>();
        selectedCountryProxy = proxy;

        getStyleClass().add("country");
        getStyleClass().add("country-selector");
        initializeControls();
        layoutControls();
        addValueChangeListeners();
    }

    /**
     * sets the political Europe
     *
     * @param europe the political Europe
     */
    public void setEurope(Europe europe) {
        this.europe = europe;
        slider.setMin(0);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(0);
        slider.setBlockIncrement(1);
        slider.getStyleClass().add("country-slider");
        slider.setSnapToTicks(true);
        slider.setMax(europe.getCountries().size() -1);
    }

    /**
     * returns the selected Country
     *
     * @return the selected Country
     */
    public Country getSelectedCountry() {
        return selectedCountry.get();
    }

    /**
     * returns the selectedCountry property
     *
     * @return the selectedCountry property
     */
    public ReadOnlyObjectProperty<Country> selectedCountryProperty() {
        return selectedCountry;
    }

    private void initializeControls() {
        slider = new Slider();
        textField = new TextField();
    }

    private void layoutControls() {
        getChildren().addAll(slider, textField);
    }

    private void addValueChangeListeners() {
        slider.valueProperty().addListener((v, o, n) -> {
            double value = slider.getValue();
            int index = (int) Math.round(value);
            Country country = europe.getCountries().get(index);

            selectedCountry.setValue(country);
            selectedCountryProxy.setSelectedCountry(country);
        });

        Bindings.bindBidirectional(textField.textProperty(), slider.valueProperty(), new NumberStringConverter());
    }
}
