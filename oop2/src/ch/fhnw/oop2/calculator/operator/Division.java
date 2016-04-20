package ch.fhnw.oop2.calculator.operator;

/**
 * Created by Kelvin on 19-Apr-16.
 */
public class Division extends BasicArithmeticOperation {
    public Division() {
        result.bind(term1.divide(term2));
    }
}
