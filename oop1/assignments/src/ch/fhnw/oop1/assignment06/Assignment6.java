import java.util.*;

/**
 * Created by Kelvin on 27.10.2015.
 */
public class Assignment6 {
    public static void main(String[] args) {
        // 1
        System.out.println(Arrays.toString(populateArray()));

        // 2
        System.out.println(average(1,2,3,4,5,6));

        // 3
        System.out.println(max(1,2,13,9,5,6));

        // 4
        String[] dogs = {"Laika", "Hachiko", "Snoopy", "Balto"};
        System.out.println(Arrays.toString(dogs));
        System.out.println(Arrays.toString(sortArray(dogs)));

        // 5
        interactive();
    }

    private static char[] populateArray() {
        char[] arr = new char[26];

        for(int i=97, x=0; x<26; x++) {
            arr[x] = (char) (i+x);
        }

        return arr;
    }

    private static double average(int...numbers) {
        double avg = 0;

        for(int x: numbers) {
            avg += x;
        }

        return avg / numbers.length;
    }

    private static int max(int...numbers) {
        int max = numbers[0];

        for(int x: numbers) {
            if (x > max) {
                max = x;
            }
        }

        return max;
    }

    private static String[] sortArray(String[] arr) {
        String[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        return sortedArr;
    }

    private static void interactive() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> ages = new ArrayList<>();

        for(int n=1; n<=2; n++) {
            System.out.printf("%d. Vorname:\t", n);
            scanner.next();

            System.out.printf("%d. Alter:\t", n);
            ages.add(scanner.nextInt());
        }

        System.out.printf("%nDifferenz:\t%d", Math.abs(ages.get(0) - ages.get(1)));
    }
}
