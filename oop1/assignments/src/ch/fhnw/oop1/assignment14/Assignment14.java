package ch.fhnw.oop1.assignment14;

/**
 * Created by Kelvin on 31-Jan-16.
 */
public class Assignment14 {
    public static void main(String[] args) {
        Canton[] cantons = {Canton.VAUD, Canton.BASEL, Canton.ZURICH, Canton.AARGAU, Canton.GENEVA};

        // To test sorting
//        Canton[] cantons = {Canton.ZURICH, Canton.VAUD, Canton.AARGAU, Canton.GENEVA, Canton.BASEL};
//        Canton[] cantons = {Canton.BASEL, Canton.GENEVA, Canton.AARGAU, Canton.VAUD, Canton.ZURICH};

        for (Canton c: cantons) {
            System.out.println(c.info());
        }

        System.out.println("=============================================");

        Canton[] sortedCantons = Canton.sortDesc(cantons);

        for (int i = 0; i < sortedCantons.length; i++) {
            Canton canton = sortedCantons[i];
            System.out.printf("%d. %s: %d %n", i+1, canton, canton.getPopulation());
        }

    }
}
