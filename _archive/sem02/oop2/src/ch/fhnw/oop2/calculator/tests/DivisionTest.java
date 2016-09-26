package ch.fhnw.oop2.calculator.tests;

import ch.fhnw.oop2.calculator.operator.BasicArithmeticOperation;
import ch.fhnw.oop2.calculator.operator.Division;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kelvin on 19-Apr-16.
 */
public class DivisionTest {
    @Test
    public void testSimpleAddition() {
        BasicArithmeticOperation division = new Division();
        division.setTerm1(5.0);
        division.setTerm2(2.5);

        assertEquals(2.0, division.resultProperty().doubleValue(), 0.1);
    }

}