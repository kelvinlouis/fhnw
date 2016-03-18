package ch.fhnw.algd1.attestation1;

/**
 * Created by Kelvin on 10-Mar-16.
 */
public class FloatPrecision {
    public static void main(String[] args) {
        float f = 1;
        double d = 1;

        for (int  i = 0; i < 15; i++) {
            f *= 256;
            System.out.println(f);
        }

        System.out.println("++++++++++++++++++++++++++++");

        for (int i = 0; i < 127; i++) {
            d *= 256;
            System.out.println(d);
        }

        System.out.println("++++++++++++++++++++++++++++");

        float f1 = 1.e9f;
        float f2 = 1_000_000_001;
        float fi = f2 - f1;

        System.out.println(fi);
        System.out.println(f1 == f2);

        System.out.println("++++++++++++++++++++++++++++");

        double d1 = 1.e9;
        double d2 = 1_000_000_001;
        double di = d2 - d1;

        System.out.println(di);
        System.out.println(d1 == d2);
    }
}
