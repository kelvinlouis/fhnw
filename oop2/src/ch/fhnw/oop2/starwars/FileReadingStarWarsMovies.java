package ch.fhnw.oop2.starwars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

/**
 * a model with file access
 */
public class FileReadingStarWarsMovies implements ApplicationModel {

    @Override
    public List<String> getData() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream("starwars.txt")))) {
            return bufferedReader.lines().collect(Collectors.toList());
        } catch (IOException exception) {
            // :(
        }
        return null;
    }
}
