package ch.fhnw.oop1.lec11;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kelvin on 17.11.2015.
 */
public class RoundedRectangleTest {

    @org.junit.Test
    public void testCircumfrence() throws Exception {
        RoundedRectangle rectangle = new RoundedRectangle(12.0, 6, 3);

        assertEquals(30.85, rectangle.getCircumfrence(), 0.01);
    }

    @org.junit.Test
    public void testCircumfrenceOfSquare() throws Exception {
        RoundedRectangle rectangle = new RoundedRectangle(8.5, 8.5, 4);

        assertEquals(27.13, rectangle.getCircumfrence(), 0.01);
    }

    @org.junit.Test()
    public void testCircumfrenceEmpty() throws Exception {
        RoundedRectangle rectangle = new RoundedRectangle();

        assertEquals(0, rectangle.getCircumfrence(), 0);
    }

    @org.junit.Test
    public void testCircumferenceNoRadius() throws Exception {
        RoundedRectangle rectangle = new RoundedRectangle(12.3, 3, 0);

        assertEquals(36.9, rectangle.getArea(), 0.1);
    }

    @org.junit.Test
    public void testAreaSquarePreceision() throws Exception {
        RoundedRectangle rectangle = new RoundedRectangle(8.35, 8.35, 2.5);

        assertEquals(64.3575, rectangle.getArea(), 0.0001);
    }

    @org.junit.Test
    public void testAreaSquare() throws Exception {
        RoundedRectangle rectangle = new RoundedRectangle(12.0, 12.0, 5);

        assertEquals(122.54, rectangle.getArea(), 0.01);
    }


    @org.junit.Test
    public void testAreaPrecision() throws Exception {
        RoundedRectangle rectangle = new RoundedRectangle(12.63, 5.95, 2.3);

        assertEquals(70.6075, rectangle.getArea(), 0.0001);
    }

    @org.junit.Test
    public void testArea() throws Exception {
        RoundedRectangle rectangle = new RoundedRectangle(11, 6, 4);

        assertEquals(52.3, rectangle.getArea(), 0.1);
    }

    @org.junit.Test
    public void testAreaEmpty() throws Exception {
        RoundedRectangle rectangle = new RoundedRectangle();

        assertEquals(0, rectangle.getArea(), 0);
    }

    @org.junit.Test
    public void testAreaNoRadius() throws Exception {
        RoundedRectangle rectangle = new RoundedRectangle(12, 3, 0);

        assertEquals(36, rectangle.getArea(), 0);
    }
}