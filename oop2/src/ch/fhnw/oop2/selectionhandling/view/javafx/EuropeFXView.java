package ch.fhnw.oop2.selectionhandling.view.javafx;

import ch.fhnw.oop2.selectionhandling.EuropePresenter;
import ch.fhnw.oop2.selectionhandling.model.Country;
import ch.fhnw.oop2.selectionhandling.model.Europe;
import ch.fhnw.oop2.selectionhandling.view.EuropeView;
import ch.fhnw.oop2.selectionhandling.view.SelectedCountryProxy;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 * the JavaFX version of EuropeView
 */
public class EuropeFXView extends VBox implements EuropeView {

    private final EuropePresenter presenter;
    private final SelectedCountryProxy selectedCountryProxy;
    private CountrySelector countrySelector;
    private CountryForm countryForm;
    private CountryPoster countryPoster;

    /**
     * creates a new EuropeFXView
     */
    public EuropeFXView() {
        // the presenter must already be created before calling
        // initializeControls()
        presenter = new EuropePresenter(this);
        selectedCountryProxy = new SelectedCountryProxy();

        initializeControls();
        layoutControls();

        // this must be the last call in the constructor
        presenter.fillView();
    }

    @Override
    public void setEurope(Europe europe) {
        countrySelector.setEurope(europe);
    }

    @Override
    public void changedName(Country country) {
        countryForm.changedName(country);
    }

    @Override
    public void changedArea(Country country) {
        countryForm.changedArea(country);
    }

    @Override
    public void showErrorMessage(String headerText, String contentText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        // Workaround, see:
        // http://stackoverflow.com/questions/28937392/javafx-alerts-and-their-size
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        Platform.runLater(() -> alert.showAndWait());
    }

    private void initializeControls() {
        countrySelector = new CountrySelector(selectedCountryProxy);
        countryForm = new CountryForm(countrySelector.selectedCountryProperty(), presenter, selectedCountryProxy);
        countryPoster = new CountryPoster(selectedCountryProxy);
    }

    private void layoutControls() {
        addRegion(countrySelector);
        addRegion(countryPoster);
        addRegion(countryForm);
    }

    private void addRegion(Region region) {
        VBox.setVgrow(region, Priority.ALWAYS);
        region.setMaxWidth(Double.MAX_VALUE);
        getChildren().add(region);
    }
}
