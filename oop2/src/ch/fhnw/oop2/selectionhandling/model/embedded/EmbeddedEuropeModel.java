package ch.fhnw.oop2.selectionhandling.model.embedded;

import ch.fhnw.oop2.selectionhandling.model.Country;
import ch.fhnw.oop2.selectionhandling.model.Europe;
import ch.fhnw.oop2.selectionhandling.model.EuropeModel;
import java.util.Arrays;

/**
 * the model of the Europe application
 */
public class EmbeddedEuropeModel implements EuropeModel {

    @Override
    public Europe getEurope() {
        return new Europe(Arrays.asList(
                new Country(0, "Schweiz", 41_285),
                new Country(1, "Deutschland", 357_121.41),
                new Country(2, "Frankreich", 668_763.00),
                new Country(3, "Italien", 301_338),
                new Country(4, "Österreich", 83_878.99)));
        // yes, there are more countries in Europe but we just keep it simple...
    }
}
