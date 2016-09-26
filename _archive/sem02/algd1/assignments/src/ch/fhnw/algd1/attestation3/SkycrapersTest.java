package ch.fhnw.algd1.attestation3;

import org.junit.Before;

import java.util.Arrays;

/**
 * Created by Kelvin on 15-Apr-16.
 */
public class SkycrapersTest {
    @Before
    public void clear() {
        System.out.println("");
    }

    @org.junit.Test()
    public void testCountSkyScrapers2by2() {
        printMatrix(Skyscrapers.countSkyscrapers(Skyscrapers.generateSimpleMatrix(2)));
    }

    @org.junit.Test()
    public void testCountSkyScrapers3by3() {
        printMatrix(Skyscrapers.countSkyscrapers(Skyscrapers.generateSimpleMatrix(3)));
    }

    @org.junit.Test()
    public void testCountSkyScrapers4by4() {
        printMatrix(Skyscrapers.countSkyscrapers(Skyscrapers.generateSimpleMatrix(4)));
    }

    private void printMatrix(int[][] m) {
        int n = m.length;

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
