package ch.fhnw.oop1.exam14;

/**
 * Created by Kelvin on 30-Jan-16.
 */
public class Ex2 {
    public static void main(String[] args) {
        Material m = new Material(7.9, "Eisen");
        Wood h = new Wood("Buche", 20);
        Stone s = new Stone(1.9, "Granit", 1.2);
        Glas g = new Glas(2.5, "Glas");
        Output a = new Output();
        a.add(m);
        a.add(h);
        a.add(s);
        a.add(g);
        m = h;
        a.add(m);
    }
}
