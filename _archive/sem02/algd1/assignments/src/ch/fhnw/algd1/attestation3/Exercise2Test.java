package ch.fhnw.algd1.attestation3;
import static org.junit.Assert.*;

/**
 * Exercise 2c
 * Created by Kelvin on 15-Apr-16.
 */
public class Exercise2Test {

    @org.junit.Test
    public void testInsertSort() throws Exception {
        double[] a1 = new double[]{ 1.456, 2.223, 3.324, 0.44, 1.2, 3.33, 3.0, 8.0, 7.2, 1.2333};
        double[] s1 = new double[]{ 0.44, 1.2, 1.2333, 1.456, 2.223, 3.0, 3.324, 3.33, 7.2, 8.0};
        assertArrayEquals(s1, Exercise2.insertSort(a1), 0);

        double[] a2 = new double[]{ 1.1, 1.1, 1.1 };
        assertArrayEquals(a2, Exercise2.insertSort(a2), 0);

        double[] a3 = new double[]{ Double.MAX_VALUE, -0.0, -0.123, -Double.MAX_VALUE, 2.3e32 };
        double[] s3 = new double[]{ -Double.MAX_VALUE, -0.123, -0.0, 2.3e32, Double.MAX_VALUE };
        assertArrayEquals(s3, Exercise2.insertSort(a3), 0);

        double[] a4 = new double[]{ 0.0, -0.0 };
        double[] s4 = new double[]{ -0.0, 0.0 };
        assertArrayEquals(s4, Exercise2.insertSort(a4), 0.0);

        double[] a5 = new double[]{ 1.2, Double.POSITIVE_INFINITY, 2.3, Double.NaN, 1.5, Double.NEGATIVE_INFINITY };
        double[] s5 = new double[]{ Double.NEGATIVE_INFINITY, 1.2, 1.5, 2.3, Double.POSITIVE_INFINITY, Double.NaN };
        assertArrayEquals(s5, Exercise2.insertSort(a5), 0);

        double[] a6 = new double[]{ 1.2 };
        assertArrayEquals(a6, Exercise2.insertSort(a6), 0);

        double[] a7 = new double[]{};
        assertArrayEquals(a7, Exercise2.insertSort(a7), 0);
    }

    @org.junit.Test
    public void testBinarySearch() throws Exception {
        double[] a1 = new double[]{ 0.0, 1.2, 3.14, 3.33 };

        assertEquals(0, Exercise2.binarySearch(a1, 0.0));
        assertEquals(1, Exercise2.binarySearch(a1, 1.2));
        assertEquals(2, Exercise2.binarySearch(a1, 3.14));
        assertEquals(3, Exercise2.binarySearch(a1, 3.33));
        assertEquals(-1, Exercise2.binarySearch(a1, 22.22));

        double[] a2 = new double[]{ 1.0, 1.111, 1.112 };
        assertEquals(0, Exercise2.binarySearch(a2, 1.0));
        assertEquals(1, Exercise2.binarySearch(a2, 1.111));
        assertEquals(2, Exercise2.binarySearch(a2, 1.112));
        assertEquals(-1, Exercise2.binarySearch(a2, 1.113));

        double[] a3 = new double[]{ 1.0, 1.1 };
        assertEquals(0, Exercise2.binarySearch(a3, 1.0));
        assertEquals(1, Exercise2.binarySearch(a3, 1.1));
        assertEquals(-1, Exercise2.binarySearch(a3, 1.2));

        double[] a4 = new double[]{ 1.0 };
        assertEquals(0, Exercise2.binarySearch(a4, 1.0));
        assertEquals(-1, Exercise2.binarySearch(a4, 2.0));

        double[] a5 = new double[]{};
        assertEquals(-1, Exercise2.binarySearch(a5, 2.2));

        double[] a6 = new double[]{ 1.0, 1.1, Double.NaN };
        assertEquals(0, Exercise2.binarySearch(a6, 1.0));
        assertEquals(1, Exercise2.binarySearch(a6, 1.1));
        assertEquals(2, Exercise2.binarySearch(a6, Double.NaN));
    }
}