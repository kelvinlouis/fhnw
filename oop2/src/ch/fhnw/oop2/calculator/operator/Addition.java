package ch.fhnw.oop2.calculator.operator;

/**
 * The basic arithmethic operation of addition
 */
public class Addition extends BasicArithmeticOperation {

    /**
     * creates a new Addition
     */
    public Addition() {
        result.bind(term1.add(term2));
    }
}
