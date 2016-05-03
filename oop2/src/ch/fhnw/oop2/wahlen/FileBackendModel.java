package ch.fhnw.oop2.wahlen;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * a model with a file backend
 */
public class FileBackendModel implements ApplicationModel {

    private List<Result> data;

    @Override
    public List<Result> getData() {
        return getData(getClass().getResourceAsStream(
                "Nationalratswahlen2007.txt"));
    }

    /**
     * returns the data from a given file
     *
     * @param path the name of the given file
     * @return the election results
     */
    public List<Result> getData(String path) {
        try {
            return getData(new FileInputStream(path));
        } catch (FileNotFoundException ex) {
            // TODO
        }
        return null;
    }

    /**
     * returns the data from a given InputStream
     *
     * @param inputSream the InputStream to read from
     * @return the election results
     */
    public List<Result> getData(InputStream inputSream) {
        data = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(inputSream))) {
            bufferedReader.lines().skip(1).forEach(c -> {
                String[] col = c.split("\t");

                data.add(new Result(col[1], col[2], Integer.parseInt(col[20]), Integer.parseInt(col[21])));
            });
        } catch (IOException exception) {
            // TODO: crash and burn
        }
        return data;
    }
}
