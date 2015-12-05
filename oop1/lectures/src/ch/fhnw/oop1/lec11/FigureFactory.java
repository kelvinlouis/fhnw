package ch.fhnw.oop1.lec11;

/**
 * Created by Kelvin on 05-Dec-15.
 */
public class FigureFactory {

    private FigureFactory() {}

    /**
     * Simplest factory possible
     * @return Figure
     */
    public static Figure create(String type) {
        switch (type) {
            case "Circle":
                return new Circle();
            case "Rectangle":
                return new Rectangle();
            case "RoundedRectangle":
                return new RoundedRectangle();
            default:
                throw new IllegalArgumentException("No Figure found for type: " + type);
        }
    }
}
