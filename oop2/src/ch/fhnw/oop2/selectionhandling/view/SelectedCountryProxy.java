package ch.fhnw.oop2.selectionhandling.view;

import ch.fhnw.oop2.selectionhandling.model.Country;
import javafx.beans.property.*;

/**
 * Created by Kelvin on 31-May-16.
 */
public class SelectedCountryProxy {
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty name = new SimpleStringProperty();
    private DoubleProperty area = new SimpleDoubleProperty();


    public void setSelectedCountry(Country country) {
        id.bind(country.idProperty());
        name.bind(country.nameProperty());
        area.bind(country.areaProperty());
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public double getArea() {
        return area.get();
    }

    public DoubleProperty areaProperty() {
        return area;
    }
}
