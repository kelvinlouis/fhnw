package ch.fhnw.oop2.calculator.operator;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * a basic mathematical operation
 */
public abstract class BasicArithmeticOperation {

    /**
     * the first term of the operation
     */
    protected final DoubleProperty term1 = new SimpleDoubleProperty(0);

    /**
     * the second term of the operation
     */
    protected final DoubleProperty term2 = new SimpleDoubleProperty(0);

    /**
     * the result of the operation
     */
    protected final DoubleProperty result = new SimpleDoubleProperty();

    /**
     * returns the first term
     *
     * @return the first term
     */
    public double getTerm1() {
        return term1.get();
    }

    /**
     * sets the first term
     *
     * @param term1Value the first term
     */
    public void setTerm1(double term1Value) {
        term1.set(term1Value);
    }

    /**
     * returns the property of the first term
     *
     * @return the property of the first term
     */
    public DoubleProperty term1Property() {
        return term1;
    }

    /**
     * returns the second term
     *
     * @return the second term
     */
    public double getTerm2() {
        return term2.get();
    }

    /**
     * sets the second term
     *
     * @param term2Value the second term
     */
    public void setTerm2(double term2Value) {
        term2.set(term2Value);
    }

    /**
     * returns the property of the second term
     *
     * @return the property of the second term
     */
    public DoubleProperty term2Property() {
        return term2;
    }

    /**
     * returns the property of the result of the operation
     *
     * @return the property of the result of the operation
     */
    public DoubleProperty resultProperty() {
        return result;
    }
}
