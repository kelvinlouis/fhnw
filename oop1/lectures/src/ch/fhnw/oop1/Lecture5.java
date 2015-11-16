package ch.fhnw.oop1;

import java.lang.StringBuilder;

/**
 * Created by Kelvin on 13.10.2015.
 */
public class Lecture5 {

    public static void main(String args[]) {

        System.out.println(addStrings(args));

        System.out.println(countLetters("ASD123"));
        System.out.println(removeSpaces("  0  1 2  3     4   5  6 7 8         9"));
        System.out.println(createStringDigits());
    }

    public static int countLetters(String string) {
        int x = 0;

        for (char ch: string.toCharArray()) {
            if (Character.isLetter(ch)) {
                x++;
            }
        }

        return x;
    }

    public static String removeSpaces(String original) {
        String newString = "";

        for(char ch: original.toCharArray()) {
            if (ch != ' ') {
                newString += ch;
            }
        }

        return newString;
    }

    public static String createStringDigits() {
        StringBuilder digits = new StringBuilder();

        for (int i = 0; i <= 9; i++) {
            digits.append(i).append((i == 9 ? "" : " "));
        }

        return digits.toString();
    }

    public static int addStrings(String[] digits) {
        int number = 0;

        for(int i = 0; i < digits.length; i++) {
            number += Integer.parseInt(digits[i]);
        }

        return number;
    }
}
