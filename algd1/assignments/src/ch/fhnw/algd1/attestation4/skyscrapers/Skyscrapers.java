package ch.fhnw.algd1.attestation4.skyscrapers;

import java.util.Arrays;

/**
 * Created by Kelvin on 12-Jun-16.
 */
public class Skyscrapers {
    static int[][] solution = new int[4][4];
    static int[][] m;

    private static boolean solve(int[] v) {
        for (int x = 0; x < 4; x++) {
            int lc = 1;
            int rc = 1;

            int lb = m[x+1][0];
            int rb = m[x+1][m.length-1];
            int tb = m[0][x+1];
            int bb = m[m.length-1][x+1];

            int lmax = v[0];
            int rmax = v[3];

            for (int i = 1; i < 4; i++) {
                int rev = (4 - 1) - i;

                if (lmax < v[i]) {
                    lmax = v[i];
                    lc++;
                }

                if (rmax < v[rev]) {
                    rmax = v[rev];
                    rc++;
                }
            }

            if (lb == lc && rb == rc) {
                System.out.println("Y(" + (x+1)  + "): " + Arrays.toString(v));
                pushRowSolution(v, x);
            }

            if (tb == lc && bb == rc) {
                System.out.println("X(" + (x+1) + "): " + Arrays.toString(v));
                pushColumnSolution(v, x);
            }
        }

        return false;
    }

    private static void pushRowSolution(int[] v, int y) {
        for (int i = 0; i< v.length; i++) {
            if (solution[y][i] == 0 || solution[i][i] == v[i])
                solution[y][i] = v[i];
        }
    }

    private static void pushColumnSolution(int[] v, int x) {
        for (int i = 0; i< v.length; i++) {
            if (solution[i][x] == 0 || solution[i][x] == v[i])
                solution[i][x] = v[i];
        }
    }

    private static void fill(int[] v, int d) {
        if (d == v.length + 1) {
            // Check if boundaries of row are correct
            if (solve(v)) {
                System.out.println("SOLVED:" + Arrays.toString(v));
            }
            return;
        }
        for (int i = 0; i < v.length; i++) {
            if (v[i] == 0) {
                v[i] = d;
                fill(v, d + 1);
                v[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        m = createMatrix();
        //int n = m.length-2;

        // Creates all rows
        fill(new int[4], 1);

        printMatrix(solution);
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
