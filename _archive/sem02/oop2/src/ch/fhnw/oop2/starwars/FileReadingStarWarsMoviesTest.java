package ch.fhnw.oop2.starwars;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Kelvin on 26-Apr-16.
 */
public class FileReadingStarWarsMoviesTest {

    @Test
    public void testGetData() throws Exception {
        FileReadingStarWarsMovies frswm = new FileReadingStarWarsMovies();
        List<String> data = frswm.getData();

        assertNotNull("Not Null", data);
        assertNotEquals("Not Empty", data.size(), 0);
        assertEquals("Really?", data.get(0), "Star Wars: Episode I - Die dunkle Bedrohung");
    }
}