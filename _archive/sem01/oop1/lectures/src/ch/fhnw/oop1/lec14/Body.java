package ch.fhnw.oop1.lec14;

/**
 * Created by Kelvin on 31-Jan-16.
 */
public abstract class Body {
    private Dryness dryness;
    private Hardness hardness;
    private Roughness roughness;

    public Body(Dryness d, Hardness h, Roughness r) {
        dryness = d;
        hardness = h;
        roughness = r;
    }

    public Hardness getHardness() {
        return hardness;
    }

    public void setHardness(Hardness h) {
        hardness = h;
    }

    public Dryness getDryness() {
        return dryness;
    }

    public void setDryness(Dryness d) {
        dryness = d;
    }

    public Roughness getRoughness() {
        return roughness;
    }

    public void setRoughness(Roughness r) {
        roughness = r;
    }
}
