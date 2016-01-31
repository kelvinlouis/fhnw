package ch.fhnw.oop1.assignment14;

/**
 * Created by Kelvin on 31-Jan-16.
 */
public enum Canton {
    BASEL(196_850, 37) {
        @Override
        public String toString() {
            return "Basel";
        }
    },
    GENEVA(482_545, 282) {
        @Override
        public String toString() {
            return "Genf";
        }
    },
    AARGAU(645_277, 1_404) {
        @Override
        public String toString() {
            return "Aargau";
        }
    },
    VAUD(761_446, 3_212) {
        @Override
        public String toString() {
            return "Waadt";
        }
    },
    ZURICH(1_443_436, 1_729) {
        @Override
        public String toString() {
            return "Zürich";
        }
    };

    private int population;
    private int area;

    Canton(int p, int a) {
        population = p;
        area = a;
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
}
