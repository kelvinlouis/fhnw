package ch.fhnw.oop2.calculator.tests;

import ch.fhnw.oop2.calculator.operator.BasicArithmeticOperation;
import ch.fhnw.oop2.calculator.operator.Multiplication;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kelvin on 19-Apr-16.
 */
public class MultiplicationTest {
    @Test
    public void testSimpleMultiplication() {
        BasicArithmeticOperation multipl = new Multiplication();
        multipl.setTerm1(2.0);
        multipl.setTerm2(3.1);

        assertEquals(6.2, multipl.resultProperty().doubleValue(), 0.01);
    }

}