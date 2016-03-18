package ch.fhnw.algd1.attestation1;

/**
 * Created by Kelvin on 10-Mar-16.
 */
public class Attestation1 {
    public static void main(String[] args) {
        int i = 97;
        //byte bi = i;   won'twork
        //char c = i;    won't work
        char c = '\n';
        byte bi = (byte) 255;
        long l = i;
        boolean b = i > c;
        float f = 2.5666f;
        System.out.println(f);
        System.out.println(i);
        double d;

        d = 2.3;

        d = f;

        l = 20/7;
        System.out.println(l);

        b = 40.0/6.0 == 6.666666;
        System.out.println(40.f/6.0f);

        b = (1/10) == 0.1;
        System.out.println((1/10));

        System.out.println(-1 * (Integer.MAX_VALUE + 1));
        System.out.println((-1 * (Integer.MAX_VALUE + 1)) == (Integer.MAX_VALUE + 1));

        float f1 = 16_777_216;
        System.out.println(f1);
        System.out.println(f1+1);

        float ff = 1;

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        for (int j = 1; j <= Math.pow(2,24); j++) {
            if (ff == (ff + 1)) {
                System.out.println(ff);
                break;
            }
            ff += 1;
        }

        double dd = Math.pow(2,53);
        System.out.println(dd == (dd+1));

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

    }
}
