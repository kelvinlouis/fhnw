package ch.fhnw.oop2.calculator.operator;

/**
 * Created by Kelvin on 19-Apr-16.
 */
public class Multiplication extends BasicArithmeticOperation {
    public Multiplication() {
        result.bind(term1.multiply(term2));
    }
}
