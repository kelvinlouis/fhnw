package ch.fhnw.oop1.exam14;

/**
 * Created by Kelvin on 30-Jan-16.
 */
public class SolidWood extends Wood implements NaturalProduct {
    private Label standard;
    private String origin;

    public SolidWood(String b, int w, Label st, String or) {
        super(b + "massive", w);
        standard = st;
        origin = origin;
    }

    @Override
    public Label getStandard() {
        return standard;
    }

    @Override
    public String getOrigin() {
        return origin;
    }
}
