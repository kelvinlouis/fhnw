package ch.fhnw.algd1.attestation2;

import java.util.Arrays;

/**
 * Created by Kelvin on 29-Mar-16.
 */
public class Attestation2 {
    private static final byte QUESTION_MARK = 63;

    private static final int BMP_LEN = 0x10000;

    private static final int HI_PREFIX = 0xD800;
    private static final int LO_PREFIX = 0xDC00;

    private static final int MASK_FIRST_10 = 0xFFC00;
    private static final int MASK_LAST_10 = 0x003FF;

    public static void main (String[] args) {
        // Exercise 2
        System.out.println(Arrays.toString(utfToLatin1("\u0041\uD800\uDF84\u0042\u03A9")));
        System.out.println(Arrays.toString(utfToLatin1("\u00FE\u00FF\u0100\u0101")));
        System.out.println(Arrays.toString(utfToLatin1("\uD83D\uDC38\u0041\uD800\uDF84\uD83D\uDD25\u0042\ud500\u00FF\u0100\u03A9")));
        System.out.println(Arrays.toString(utfToLatin1("\uDBFF\uDF80")));

        // Exercise 3b
        System.out.println(utf32To16(0xF900, new char[]{'\u0041', '\u0042'}, 0));
        System.out.println(utf32To16(0x26F5, new char[]{'\u0041', '\u0042'}, 1));
        System.out.println(utf32To16(0x21, new char[]{'\u0041', '\u0042'}, 0));
        System.out.println(utf32To16(0x0, new char[]{'\u0041', '\u0042'}, 0));
        System.out.println(utf32To16(0x1F438, new char[]{'\u0041', '\u0042', '0'}, 0));
        System.out.println(utf32To16(0x10384, new char[]{'\u0041', '\u0042', '0'}, 1));
        System.out.println(utf32To16(0x10FFFF, new char[]{'\u0041', '\u0042', '0'}, 1));
        // System.out.println(utf32To16(0x1F438, new char[]{'\u0041', '\u0042'}, 1)); Throws exception
    }

    public static byte[] utfToLatin1(String s) {
        byte[] b = new byte[s.length()];
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= 0xD800 && c <= 0xDBFF) {
                // Only skip next char if high surrogate
                b[j++] = QUESTION_MARK;
                i++;
            } else {
                if ((c & 0xFF00) > 0) {
                    b[j++] = QUESTION_MARK;
                } else {
                    b[j++] = (byte) (c & 0x00FF);
                }
            }
        }

        return b;
    }

    public static int utf32To16 (int c, char[] array, int pos) {
        if (c > 0x10FFFF)
            throw new IllegalArgumentException("Not a valid UTF-32 character (max 0x10FFFF");
        if (pos < 0 || pos >= array.length)
            throw new IllegalArgumentException("Position is out of bounds");

        if (c < BMP_LEN) {
            // BMP
            array[pos] = (char) c;

            return 1;
        } else {
            if ((pos+1) >= array.length)
                throw new ArrayIndexOutOfBoundsException("The surrogate pair can't be stored in array");

            // BMP+
            c -= BMP_LEN;

            array[pos] = (char) (HI_PREFIX | ((c & MASK_FIRST_10) >> 10)); // high
            array[pos+1] = (char) (LO_PREFIX | (c & MASK_LAST_10)); // low

            return 2;
        }
    }
}
