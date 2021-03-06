package ch.fhnw.algd1.attestation3;

/**
 * Created by Kelvin on 15-Apr-16.
 */
public class Exercise2 {
    public static void main(String[] args) {}

    // Exercise 2a
    public static double[] insertSort(double[] arr) {
        int n = arr.length;

        for (int f = 1; f < n; f++) {
            double x = arr[f];
            int e = f-1;

            while (e >= 0 && (arr[e] > x || Double.isNaN(arr[e]))) {
                arr[e+1] = arr[e];
                e--;
            }
            arr[e+1] = x;
        }
        return arr;
    }

    // Exercise 2b
    public static int binarySearch(double[] arr, double s) {
        int min = 0;
        int max = arr.length - 1;

        while (max >= min) {
            int p = min + max >>> 1;
            //int p = min + ((max - min)/2);

            if (Double.compare(s, arr[p]) == -1) {
                max = p-1;
            } else if (Double.compare(s, arr[p]) == 1) {
                min = p+1;
            } else {
                return p;
            }
        }

        return -1;
    }
}
