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

        Canton[] sortedCantons = sortCantonsDesc(cantons);

        for (int i = 0; i < sortedCantons.length; i++) {
            Canton canton = sortedCantons[i];
            System.out.printf("%d. %s: %d %n", i+1, canton, canton.getPopulation());
        }

    }

    /**
     * Lambdas and comparators are not allowed...
     */
    public static Canton[] sortCantonsDesc(Canton[] cantons) {
        Canton[] sortedCantons = new Canton[cantons.length];

        for (int i = 0; i < cantons.length; i++) {
            Canton c = cantons[i];

            for (int y = 0; y < sortedCantons.length; y++) {
                Canton sc = sortedCantons[y];

                if (sc == null) {
                    sortedCantons[y] = c;
                    break;
                } else if (c.compareTo(sc) > 0) {
                    sortedCantons[y] = c;
                    c = sc;
                    continue;
                }
            }
        }

        return sortedCantons;
    }
}
