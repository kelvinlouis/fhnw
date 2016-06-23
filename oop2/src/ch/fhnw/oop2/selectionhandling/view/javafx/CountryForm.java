package ch.fhnw.oop2.selectionhandling.view.javafx;

import ch.fhnw.oop2.selectionhandling.EuropePresenter;
import ch.fhnw.oop2.selectionhandling.model.Country;
import java.util.ResourceBundle;

import ch.fhnw.oop2.selectionhandling.view.SelectedCountryProxy;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * a form for countries
 */
public class CountryForm extends GridPane {

    private final ResourceBundle STRINGS = ResourceBundle.getBundle(
            "ch.fhnw.oop2.selectionhandling.view.javafx.Strings");

    private final ReadOnlyObjectProperty<Country> selectedCountry;
    private final SelectedCountryProxy selectedCountryProxy;
    private final EuropePresenter presenter;

    private Label idLabel;
    private Label idValueLabel;
    private Label nameLabel;
    private TextField nameTextField;
    private Label areaLabel;
    private TextField areaTextField;
    private Label areaUnitLabel;

    private boolean ignoreCallback = false;

    /**
     * creates a new CountryForm
     *
     * @param presenter the presenter of the Europe app
     */
    public CountryForm(ReadOnlyObjectProperty<Country> country,
            EuropePresenter presenter, SelectedCountryProxy proxy) {

        this.selectedCountry = country;
        this.presenter = presenter;
        this.selectedCountryProxy = proxy;

        getStyleClass().add("country");
        getStyleClass().add("country-form");
        initializeControls();
        layoutControls();
        addValueChangeListeners();
    }

    private void initializeControls() {
        idLabel = new Label(STRINGS.getString("ID"));
        idValueLabel = new Label("0");
        nameLabel = new Label(STRINGS.getString("Name"));
        nameTextField = new TextField();
        areaLabel = new Label(STRINGS.getString("Area"));
        areaTextField = new TextField();
        areaUnitLabel = new Label("km²");
    }

    private void layoutControls() {
        addRow(0, idLabel, idValueLabel);
        addRow(1, nameLabel, nameTextField);
        addRow(2, areaLabel, areaTextField, areaUnitLabel);
    }

    private void addValueChangeListeners() {

        selectedCountry.addListener((observable, oldValue, newValue) -> {
            ignoreCallback = true;
            idValueLabel.textProperty().bind(selectedCountryProxy.idProperty().asString());
            nameTextField.textProperty().bind(selectedCountryProxy.nameProperty());
            areaTextField.textProperty().bind(selectedCountryProxy.areaProperty().asString());
            ignoreCallback = false;
        });

        nameTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (ignoreCallback == false) {
                presenter.setName(selectedCountry.get(), newValue);
            }
        });

        areaTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (ignoreCallback == false) {
                presenter.setArea(selectedCountry.get(), Double.parseDouble(newValue));
            }
        });
    }

    /**
     * signals that the name of the country changed
     *
     * @param country the country
     */
    public void changedName(Country country) {
        nameTextField.textProperty().set(country.getName());
    }

    /**
     * signals that the area of the country changed
     *
     * @param country the country
     */
    void changedArea(Country country) {
        areaTextField.textProperty().set(String.valueOf(country.getArea()));
    }
}
