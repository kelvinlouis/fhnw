package ch.fhnw.oop2.calculator.tests;

import ch.fhnw.oop2.calculator.operator.Addition;
import ch.fhnw.oop2.calculator.operator.BasicArithmeticOperation;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kelvin on 19-Apr-16.
 */
public class AdditionTest {
    @Test
    public void testSimpleAddition() {
        BasicArithmeticOperation addition = new Addition();
        addition.setTerm1(2.0);
        addition.setTerm2(3.1);

        assertEquals(5.1, addition.resultProperty().doubleValue(), 0.1);
    }

}