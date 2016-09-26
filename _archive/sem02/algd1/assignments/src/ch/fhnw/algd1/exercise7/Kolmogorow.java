package ch.fhnw.algd1.exercise7;

/**
 * Created by Kelvin on 23-Jun-16.
 */
public class Kolmogorow {
    public static void main(String[] args) {
        str1(20);
        System.out.println();
        str2(20);
        str3(0);
    }

    private static void str1(int n) {
        int m = 1, i = 1;
        while (--n > -1) {
            if (i%m == 0) {
                System.out.print(1);
                m++;
                i=1;
            } else {
                System.out.print(0);
                i++;
            }
        }
    }

    private static void str2(int n) {
        int a = 1, b = 1, d = a, c = 1;
        while (--n > -1) {
            System.out.print(c);
            if (--d == 0) {
                d = a + b;
                a = b;
                b = d;
                c = 1 - c;
            }
        }
    }

    private static void str3() {
        
    }
}
