import java.lang.String;
import java.lang.System;
import java.util.Arrays;

/**
 * Created by Kelvin on 14.10.2015.
 */
public class Assignment5 {

    public static void main(String[] args) {
        int[] values = {7,3,5,0,9,4,1,7,2,9,1,39};

        System.out.println(min(values));
        System.out.println(min2(values));
        System.out.println(min3(values));
        System.out.println(minPos(values));
    }

    // cleaner, but one iteration unnecessary
    public static int min(int[] list) {
        int min = list[0];

        for (int x: list) {
            min = x < min ? x : min;
        }

        return min;
    }

    // slightly optimized, conventional
    public static int min2(int[] list) {
        int min = list[0];

        for (int i = 1; i < list.length; i++) {
            min = list[i] < min ? list[i] : min;
        }

        return min;
    }

    // still not like haskell, but close
    public static int min3(int[] list) {
        return Arrays.stream(list).min().getAsInt();
    }

    // conventional
    public static int minPos(int[] list) {
        int pos = 0,
            min = list[0];

        for (int i = 1; i <= list.length; i++) {
            if (list[i] < min){
                min = list[i];
                pos = i;
            }
        }

        return pos;
    }
}
