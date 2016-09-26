package ch.fhnw.oop2.calculator.operator;

/**
 * Created by Kelvin on 19-Apr-16.
 */
public class Subtraction extends BasicArithmeticOperation {
    public Subtraction() {
        result.bind(term1.subtract(term2));
    }
}
