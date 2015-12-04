package ch.fhnw.oop1.lec11;

import static org.junit.Assert.*;

/**
 * Created by Kelvin on 17.11.2015.
 */
public class CircleTest {

    @org.junit.Test
    public void testCircumfrence() throws Exception {
        Circle circle = new Circle(4);

        assertEquals(25.13, circle.getCircumfrence(), 0.01);
    }

    @org.junit.Test()
    public void testCircumfrenceEmpty() throws Exception {
        Circle circle = new Circle();

        assertEquals(0, circle.getCircumfrence(), 0);
    }

    @org.junit.Test
    public void testArea() throws Exception {
        Circle circle = new Circle(4);

        assertEquals(50.27, circle.getArea(), 0.01);
    }

    @org.junit.Test
    public void testAreaEmpty() throws Exception {
        Circle circle = new Circle();

        assertEquals(0, circle.getArea(), 0);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testSetRadiusNegative() throws Exception {
        new Circle(-1);
    }
}