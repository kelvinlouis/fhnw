package ch.fhnw.algd1.attestation4.skyscrapers;

import java.util.Arrays;

/**
 * Created by Kelvin on 12-Jun-16.
 */
public class Skyscrapers {

    static int[][] m;

    private static boolean solve(int[] v, int row) {
        int lb = m[row][0];
        int rb = m[row][m.length-1];
        int lc = 1;
        int rc = 1;

        for (int i = 1; i < 4; i++) {
            int rev = (4 - 1) - i;

            if (v[0] < v[i]) {
                lc++;
            }

            if (v[3] < v[rev]) {
                rc++;
            }
        }

        return lc == lb && rc == rb;
    }

    private static void fill(int[] v, int x, int y) {
        if (x == v.length + 1) {
            // Check if boundaries of row are correct
            if (solve(v, y)) {
                System.out.println(y + "(Y): " + Arrays.toString(v));
            }
            return;
        }
        for (int i = 0; i < v.length; i++) {
            if (v[i] == 0) {
                v[i] = x;
                fill(v, x + 1, y);
                v[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        m = createMatrix();
        int n = m.length-2;

        // Creates all rows
        for (int y = 1; y <= n; y++) {
            fill(new int[4], 1, y);
        }

        //printMatrix(m);
    }

    public static int[][] createMatrix() {
        int[][] matrix = new int[6][6];

        // top row
        matrix[0][1] = 1;
        matrix[0][2] = 3;
        matrix[0][3] = 2;
        matrix[0][4] = 2;

        // right row
        matrix[1][5] = 2;
        matrix[2][5] = 2;
        matrix[3][5] = 1;
        matrix[4][5] = 3;

        // bottom row
        matrix[5][1] = 3;
        matrix[5][2] = 1;
        matrix[5][3] = 2;
        matrix[5][4] = 2;

        // left row
        matrix[1][0] = 1;
        matrix[2][0] = 3;
        matrix[3][0] = 2;
        matrix[4][0] = 2;

        return matrix;
    }

    public static void printMatrix(int[][] m) {
        int n = m.length;

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
