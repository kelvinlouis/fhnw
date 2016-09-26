package ch.fhnw.algd1.attestation1;

/**
 * Created by Kelvin on 11-Mar-16.
 */
public class Exercise4 {
    private static final int[] H = new int[]{1, 3, 9, 27};

    public static void main(String[] args) {
        exerciseA();
        System.out.println("++++++++++++++++++++++++++");
        exerciseB();
    }

    public static void exerciseA() {
        int a;
        int b = -1;
        int c = -1;
        int d = -1;

        for (int i = 0; i < Math.pow(3, H.length); i++) {
            a = i % 3;

            if (i%H[1] == 0) b = b == 2 ? 0 : b + 1;
            if (i%H[2] == 0) c = c == 2 ? 0 : c + 1;
            if (i%H[3] == 0) d = d == 2 ? 0 : d + 1;

            int sum = d * H[3] + c * H[2] + b * H[1] + a * H[0];

            System.out.println(sum);
        }
    }

    public static void exerciseB() {
        int a;
        int b = -1;
        int c = -1;
        int d = -1;

        for (int i = 0; i < Math.pow(2, H.length); i++) {
            a = i % 2;

            if (i%2 == 0) b = b == 1 ? 0 : b + 1;
            if (i%4 == 0) c = c == 1 ? 0 : c + 1;
            if (i%8 == 0) d = d == 1 ? 0 : d + 1;

            int sum = d * H[3] + c * H[2] + b * H[1] + a * H[0];

            System.out.println(sum);
        }
    }
}
