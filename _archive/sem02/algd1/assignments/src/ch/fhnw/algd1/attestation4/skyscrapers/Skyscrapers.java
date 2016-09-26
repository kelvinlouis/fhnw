package ch.fhnw.algd1.attestation4.skyscrapers;

/**
 * Created by Kelvin on 12-Jun-16.
 */
public class Skyscrapers {
    static int[][] m;
    static int n;

    public static void main(String[] args) {
        m = createMatrix();
        n = m.length-2;

        // Creates all rows
        fill(1, 1);

        printMatrix(m);
    }

    private static boolean fill(int row, int col) {
        for (int i = 1; i <= n; i++) {
            m[row][col] = i;

            if (isValid(row, col)) {
                if (col < n) {
                    if (fill(row, col + 1))
                        return true;
                } else {
                    if (row < n) {
                        if (fill(row + 1, 1))
                            return true;
                    } else {
                        // DONE
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean isValid(int row, int col) {
        return isRowValid(row, col) && isColValid(row, col) && isHeightsValid(row, col);
    }

    private static boolean isRowValid(int row, int col) {
        // Check dupes
        for (int i=1; i<col; i++) {
            if(m[row][i] == m[row][col])
                return false;
        }

        return true;
    }

    private static boolean isColValid(int row, int col) {
        // Check dupes
        for (int i=1; i<row; i++) {
            if(m[i][col] == m[row][col])
                return false;
        }

        return true;
    }

    private static boolean isHeightsValid(int row, int col) {
        boolean validRowHeights = true;
        boolean validColumnHeights = true;

        if (col == n) {
            validRowHeights = checkRowHeights(m[row][0], m[row][n+1], row);
        }

        if (row == n) {
            validRowHeights = checkColHeights(m[0][col], m[n+1][col], col);
        }

        return validRowHeights && validColumnHeights;
    }

    private static boolean checkRowHeights(int fHeight, int lHeight, int row) {
        int fMax = m[row][1];
        int lMax = m[row][n];

        int fc = 0;
        int lc = 0;

        for (int i = 2; i <= n; i++) {
            int rev = n - i + 1;

            if (fMax < m[row][i]) {
                fMax = m[row][i];
                fc++;
            }

            if (lMax < m[row][rev]) {
                lMax = m[row][rev];
                lc++;
            }
        }

        return fc == fHeight && lc == lHeight;
    }

    private static boolean checkColHeights(int fHeight, int lHeight, int col) {
        int fMax = m[1][col];
        int lMax = m[n][col];

        int fc = 0;
        int lc = 0;

        for (int i = 2; i <= n; i++) {
            int rev = n - i + 1;

            if (fMax < m[i][col]) {
                fMax = m[i][col];
                fc++;
            }

            if (lMax < m[rev][col]) {
                lMax = m[rev][col];
                lc++;
            }
        }

        return fc == fHeight && lc == lHeight;
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
