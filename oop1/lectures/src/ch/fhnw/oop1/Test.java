package ch.fhnw.oop1;

/**
 * Created by Kelvin on 26.10.2015.
 */
public class Test {

    public static void main (String[] args) {
        int dice = 3;
        int sides = 6;

        System.out.println("Test" + (char) 12);

        for(int i = dice*sides; i > 0; i--) {
            System.out.printf("Für %d gibt es %d Möglichkeit/en\n", i, calculatePossibility(i, sides));
        }

        for(char c = 'A'; c <= 'z'; c++) {
            System.out.println(c);
        }
    }

    private static int calculatePossibility(int num, int sides) {
        int possibilities = 0;

        for(int x=1; x<=sides; x++) {
            for(int y=1; y<=sides; y++) {
                for(int z=1; z<=sides; z++) {
                    if ((x+y+z) == num) {
                        possibilities++;
                    }
                }
            }
        }

        return possibilities;
    }
}
