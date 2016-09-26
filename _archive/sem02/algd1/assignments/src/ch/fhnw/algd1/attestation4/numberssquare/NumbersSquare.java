package ch.fhnw.algd1.attestation4.numberssquare;

import java.util.Arrays;

/**
 * Created by Kelvin on 12-Jun-16.
 */
public class NumbersSquare {
    private static int[] permutation;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        create(new int [9], 1);

        System.out.println(min);
        System.out.println(Arrays.toString(permutation));
    }

    private static void create(int[] v, int current) {
        if (current == v.length + 1) {
            int sum =  (v[0]*v[1]*v[2]) + (v[3]*v[4]*v[5]) + (v[6]*v[7]*v[8]) +
                       (v[0]*v[3]*v[6]) + (v[1]*v[4]*v[7]) + (v[2]*v[5]*v[8]);

            if (sum < min) {
                min = sum;
                permutation = v.clone();
            }

            return;
        }
        for (int i = 0; i < v.length; i++) {
            if (v[i] == 0) {
                v[i] = current;
                create(v, current + 1);
                v[i] = 0;
            }
        }
    }
}
