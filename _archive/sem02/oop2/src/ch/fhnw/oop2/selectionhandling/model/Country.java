package ch.fhnw.oop2.selectionhandling.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * a country
 */
public class Country {

    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final DoubleProperty area = new SimpleDoubleProperty();

    /**
     * creates a new Country
     *
     * @param id the ID of the country
     * @param name the name of the country
     * @param area the area of the country
     */
    public Country(int id, String name, double area) {
        setId(id);
        setName(name);
        setArea(area);
    }

    @Override
    public String toString() {
        return "ID = " + id.get()
                + ", name = " + name.get()
                + ", area = " + area.get();
    }

    /**
     * returns the ID of the country
     *
     * @return the ID of the country
     */
    public int getId() {
        return id.get();
    }

    /**
     * sets the ID of the country
     *
     * @param id the ID of the country
     */
    public final void setId(int id) {
        this.id.set(id);
    }

    /**
     * returns the ID property
     *
     * @return the ID property
     */
    public IntegerProperty idProperty() {
        return id;
    }

    /**
     * returns the name of the country
     *
     * @return the name of the country
     */
    public String getName() {
        return name.get();
    }

    /**
     * sets the name of the country
     *
     * @param name the name of the country
     */
    public final void setName(String name) {
        this.name.set(name);
    }

    /**
     * returns the name property
     *
     * @return the name property
     */
    public StringProperty nameProperty() {
        return name;
    }

    /**
     * returns the area of the country
     *
     * @return the area of the country
     */
    public double getArea() {
        return area.get();
    }

    /**
     * sets the area of the country
     *
     * @param area the area of the country
     */
    public final void setArea(double area) {
        this.area.set(area);
    }

    /**
     * returns the area property
     *
     * @return the area property
     */
    public DoubleProperty areaProperty() {
        return area;
    }
}
