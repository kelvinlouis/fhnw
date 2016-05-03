package ch.fhnw.oop2.starwars;

import java.util.ArrayList;
import java.util.List;

/**
 * an embedded model (without any file access)
 */
public class EmbeddedStarWarsMovies implements ApplicationModel {

    @Override
    public List<String> getData() {
        List<String> myData = new ArrayList<>();
        myData.add("Star Wars: Episode I - Die dunkle Bedrohung");
        myData.add("Star Wars: Episode II - Angriff der Klonkrieger");
        myData.add("Star Wars: Episode III - Die Rache der Sith");
        myData.add("Star Wars: Episode IV - Eine neue Hoffnung");
        myData.add("Star Wars: Episode V - Das Imperium schlägt zurück");
        myData.add("Star Wars: Episode VI - Die Rückkehr der Jedi-Ritter");
        myData.add("Star Wars: Das Erwachen der Macht");
        return myData;
    }
}
