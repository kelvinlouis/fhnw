package ch.fhnw.oop1.lec14;

/**
 * Created by Kelvin on 31-Jan-16.
 */
public class Cube extends Body {
    private int edgeLength;

    public Cube(int e, Dryness d, Hardness h, Roughness r) {
        super(d, h, r);
        edgeLength = e;
    }

    public int getEdgeLength() {
        return edgeLength;
    }

    public void setEdgeLength(int e) {
        edgeLength = e;
    }
}
