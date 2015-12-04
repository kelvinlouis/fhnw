package ch.fhnw.oop1.lec11;

import static org.junit.Assert.*;

/**
 * Created by Kelvin on 17.11.2015.
 */
public class RectangleTest {

    @org.junit.Test
    public void testCircumfrence() throws Exception {
        Rectangle rectangle = new Rectangle(5.75, 15.5);

        assertEquals(42.5, rectangle.getCircumfrence(), 2);
    }

    @org.junit.Test
    public void testCircumfrenceOfSquare() throws Exception {
        Rectangle rectangle = new Rectangle(4, 4);

        assertEquals(16, rectangle.getCircumfrence(), 2);
    }

    @org.junit.Test()
    public void testCircumfrenceEmpty() throws Exception {
        Rectangle rectangle = new Rectangle();

        assertEquals(0, rectangle.getCircumfrence(), 0);
    }

    @org.junit.Test
    public void testAreaSquarePreceision() throws Exception {
        Rectangle rectangle = new Rectangle(5.35, 5.35);

        assertEquals(28.6225, rectangle.getArea(), 0.0001);
    }

    @org.junit.Test
    public void testAreaSquare() throws Exception {
        Rectangle rectangle = new Rectangle(5.35, 5.35);

        assertEquals(28.62, rectangle.getArea(), 0.01);
    }


    @org.junit.Test
    public void testAreaPrecision() throws Exception {
        Rectangle rectangle = new Rectangle(5.0, 5.75);

        assertEquals(28.75, rectangle.getArea(), 0.05);
    }

    @org.junit.Test
    public void testArea() throws Exception {
        Rectangle rectangle = new Rectangle(5.0, 5.75);

        assertEquals(28.8, rectangle.getArea(), 0.1);
    }

    @org.junit.Test
    public void testAreaEmpty() throws Exception {
        Rectangle rectangle = new Rectangle();

        assertEquals(0, rectangle.getArea(), 0);
    }
}