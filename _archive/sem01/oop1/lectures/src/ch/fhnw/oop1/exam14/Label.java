package ch.fhnw.oop1.exam14;

/**
 * Created by Kelvin on 30-Jan-16.
 */
public enum Label {
    FSC (2,3,2), PEFC (2,2,2), FAIRSTONE (2,2,0);

    private int transparency;
    private int control;
    private int certification;

    Label(int tr, int co, int ce) {
        transparency = tr;
        control = co;
        certification = ce;
    }

    public int getControl() {
        return control;
    }

    public String getControlText() {
        switch (control) {
            case 0:
                return "bad";
            case 1:
                return "passed";
            case 2:
                return "good";
            case 3:
                return "very good";
            default:
                return "undefined";
        }
    }

    public double getAverageRating() {
        return (transparency + control + certification) / 3.0;
    }
}
