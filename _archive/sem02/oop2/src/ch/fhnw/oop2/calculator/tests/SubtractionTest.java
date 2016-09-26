package ch.fhnw.oop2.calculator.tests;

import ch.fhnw.oop2.calculator.operator.BasicArithmeticOperation;
import ch.fhnw.oop2.calculator.operator.Subtraction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kelvin on 19-Apr-16.
 */
public class SubtractionTest {
    @Test
    public void testSimpleSubtraction() {
        BasicArithmeticOperation subtraction = new Subtraction();
        subtraction.setTerm1(2.0);
        subtraction.setTerm2(3.1);

        assertEquals(-1.1, subtraction.resultProperty().doubleValue(), 0.1);
    }

}