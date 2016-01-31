package ch.fhnw.oop1.assignment14;

/**
 * Created by Kelvin on 31-Jan-16.
 */
public enum Canton {
    BS("Basel", 196_850, 37),
    GE("Genf", 482_545, 282),
    AG("Aargau", 645_277, 1_404),
    VD("Waadt", 761_446, 3_212),
    ZH("Zürich", 1_443_436, 1_729);

    private String locale_de;
    private int population;
    private int area;

    Canton(String de, int p, int a) {
        locale_de = de;
        population = p;
        area = a;
    }

    @Override
    public String toString() {
        return locale_de;
    }

    public String info() {
        return String.format("%s: %d (Population) / %d km2 (Area)", toString(), population, area);
    }

    public int getPopulation() {
        return population;
    }

    public int getArea() {
        return area;
    }

    /**
     * Lambdas and comparators are not allowed...
     */
    public static Canton[] sortDesc(Canton[] cantons) {
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
