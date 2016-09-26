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

    @org.junit.Test
    public void testGetCapitalIndexA() throws Exception {
        System.out.println("getCapitalIndex A");

        char character = 'A';
        Simple instance = new Simple();
        int expResult = 0;
        int result = instance.getIndex(character);
        assertEquals(expResult, result);
    }

    @org.junit.Test
    public void testGetCapitalIndexB() throws Exception {
        System.out.println("getCapitalIndex B");

        char character = 'B';
        Simple instance = new Simple();
        int expResult = 1;
        int result = instance.getIndex(character);
        assertEquals(expResult, result);
    }


    @org.junit.Test
    public void testGetCharOf0() throws Exception {
        System.out.println("indexToChar 0");

        Simple instance = new Simple();
        assertEquals('a', instance.indexToChar(0));
    }

    @org.junit.Test
    public void testGetCharOf1() throws Exception {
        System.out.println("indexToChar 1");

        Simple instance = new Simple();
        assertEquals('b', instance.indexToChar(1));
    }

    @org.junit.Test
    public void testGetCharOf25() throws Exception {
        System.out.println("indexToChar 25");

        Simple instance = new Simple();
        assertEquals('z', instance.indexToChar(25));
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testGetCharOf26() throws Exception {
        System.out.println("indexToChar 26");

        Simple instance = new Simple();
        instance.indexToChar(26);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testGetCharOfMinus2() throws Exception {
        System.out.println("indexToChar -2");

        Simple instance = new Simple();
        instance.indexToChar(-2);
    }

    @org.junit.Test
    public void testGetCharOfMinusIndex() throws Exception {
        System.out.println("indexToChar -1");

        Simple instance = new Simple();

        try {
            instance.indexToChar(-1);
            fail("Expected Illegal Arguments Exception");
        } catch (IllegalArgumentException e) {
        }
    }
}