package ch.fhnw.oop1.exam14;

/**
 * Created by Kelvin on 30-Jan-16.
 */
public class Part {
    private Piece[] pieces;

    public Part(int amount) {
        pieces = new Piece[amount];
    }

    public void add(double amount, Material m) {
        for (Piece p: pieces) {
            if (p != null && p.getMaterial().equals(m)) {
                p.add(amount);
                return;
            }
        }

        for (int i = 0; i < pieces.length; i++) {
            if (pieces[i] == null) {
                pieces[i] = new Piece(m, amount);
                return;
            }
        }
    }

    public double averageWood() {
        int woods = 0;
        double weight = 0;

        for (Piece p: pieces) {
            if (p.getMaterial() instanceof Wood) {
                woods++;
                weight += p.getWeight();
            }
        }

        return weight / woods;
    }

    public Stone getSmallestStone() {
        Stone smallest = null;

        for (Piece p: pieces) {
            if (p != null && (p.getMaterial() instanceof Stone)) {
                Stone s = (Stone) p.getMaterial();

                if (smallest == null) {
                    smallest = s;
                } else if (smallest.getDiameter() > s.getDiameter()) {
                    smallest = s;
                }
            }
        }

        return smallest;
    }

    public NaturalProduct[] getLabelElements(Label l) {
        int counter = 0;
        NaturalProduct[] products;

        for (Piece p: pieces) {
            if (p != null && (p.getMaterial() instanceof NaturalProduct)) {
                NaturalProduct np = (NaturalProduct) p.getMaterial();

                if (np.getStandard().equals(l)) {
                    counter++;
                }
            }
        }

        int dec = counter;
        products = new NaturalProduct[counter];

        for (Piece p: pieces) {
            if (p != null && (p.getMaterial() instanceof NaturalProduct)) {
                NaturalProduct np = (NaturalProduct) p.getMaterial();

                if (np.getStandard().equals(l)) {
                    products[counter-dec] = np;
                    dec--;
                }
            }
        }

        return products;
    }
}
