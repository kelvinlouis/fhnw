package ch.fhnw.algd1.attestation3;

/**
 * Created by Kelvin on 15-Apr-16.
 */

public class Skyscrapers {
    /**
     * Simple algorithm to create n-n matrix as described in exercise 1a)
     *
     * @param n
     * @return
     */
    public static int[][] generateSimpleMatrix(int n) {
        int[][] matrix = new int[n][n];

        for (int col=0; col<n; col++) {
            for (int row=0; row<n; row++) {
                int h = row == 0 ? col + 1 : matrix[row-1][col] + 1;

                if (h > n) {
                    h -= n;
                }

                matrix[row][col] = h;
            }
        }

        return matrix;
    }

    /**
     * Generates a new matrix including the counted skyscrapers per row and column,
     * as required in exercise 1b).
     * @param m
     * @return
     */
    public static int[][] countSkyscrapers(int[][] m) {
        int n = m.length;
        int[][] cm = new int[n + 2][n + 2];

        for (int i=0; i<n; i++) {
            int lc = 1, rc = 1, tc = 1, bc = 1; // counters

            int left    = m[i][0];
            int right   = m[i][n-1];
            int top     = m[0][i];
            int bottom  = m[n-1][i];

            // traverse through rows and columns
            for (int j=0; j<n; j++) {
                int reverse = n - (j+1);

                if (left < m[i][j]) {
                    lc++;
                    left = m[i][j];
                }

                if (right < m[i][reverse]) {
                    rc++;
                    right = m[i][reverse];
                }

                if (top < m[j][i]) {
                    tc++;
                    top = m[j][i];
                }

                if (bottom < m[reverse][i]) {
                    bc++;
                    bottom = m[reverse][i];
                }

                // Add skyscrapers to counted matrix (consider offset)
                cm[i+1][j+1] = m[i][j];
            }

            cm[i+1][0] = lc;
            cm[i+1][n+1] = rc;
            cm[0][i+1] = tc;
            cm[n+1][i+1] = bc;
        }

        return cm;
    }
}
