package ch.fhnw.oop1.lec14.material;

/**
 * Created by Kelvin on 05-Jan-16.
 */
public class Cube extends Body {
    private int edgeLength;

    public Cube(int edgeLength, Enum mat) {
        super(mat);
        this.edgeLength = edgeLength;
    }

    public int getEdgeLength() {
        return edgeLength;
    }

    public void setEdgeLength(int edgeLength) {
        this.edgeLength = edgeLength;
    }
}
