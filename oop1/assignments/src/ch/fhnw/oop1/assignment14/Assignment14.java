package ch.fhnw.oop1.assignment14;

/**
 * Created by Kelvin on 31-Jan-16.
 */
public class Assignment14 {
    public static void main(String[] args) {
        Canton[] cantons = {Canton.VD, Canton.BS, Canton.ZH, Canton.AG, Canton.GE};

        // To test sorting
//        Canton[] cantons = {Canton.ZH, Canton.VD, Canton.AG, Canton.GE, Canton.BS};
//        Canton[] cantons = {Canton.BS, Canton.GE, Canton.AG, Canton.VD, Canton.ZH};
//        Canton[] cantons = {Canton.GE, Canton.AG, Canton.ZH, Canton.BS, Canton.VD};

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
