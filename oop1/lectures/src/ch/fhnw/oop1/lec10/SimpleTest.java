package ch.fhnw.oop1.lec10;

import static org.junit.Assert.*;

/**
 * Created by Kelvin on 17.11.2015.
 */
public class SimpleTest {

    @org.junit.Test
    public void testGetIndexA() throws Exception {
        System.out.println("getIndexA");
        char character = 'a';
        Simple instance = new Simple();
        int expResult = 0;
        int result = instance.getIndex(character);
        assertEquals(expResult, result);
    }

    @org.junit.Test
    public void testGetIndexB() throws Exception {
        System.out.println("getIndexB");
        char character = 'b';
        Simple instance = new Simple();
        int expResult = 1;
        int result = instance.getIndex(character);
        assertEquals(expResult, result);
    }
}