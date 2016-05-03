package ch.fhnw.oop2.calculator;

import ch.fhnw.oop2.calculator.operator.*;
import javafx.scene.control.Label;

/**
 * Created by Kelvin on 19-Apr-16.
 */
public class Presenter {
    private Label label; // CHANGE TODO
    private final Addition addition;
    private final Subtraction subtraction;
    private final Division division;
    private final Multiplication multiplication;
    private final ApplicationView view;

    public Presenter(ApplicationView view) {
        this.view = view;

        addition = new Addition();
        subtraction = new Subtraction();
        division = new Division();
        multiplication = new Multiplication();
    }

    public void flipSign() {
        String txt = label.getText();

        if (txt.charAt(0) == '-') {
            label.setText(txt.substring(1,txt.length()));
        } else {
            label.setText("-" + txt);
        }
    }

    public void clear() {
        label.setText("");
    }

    public void calculate(BasicArithmeticOperation nextOperation) {
        // TODO
    }

    public void add() {
        // TODO
    }

    public void subtract() {
        // TODO
    }

    public void multiply() {
        // TODO
    }

    public void divide() {
        // TODO
    }

    public void removeLast() {
        String txt = label.getText();
        label.setText(txt.substring(0, txt.length() -1));
    }

    public void enterDigit(String digit) {
        String txt = label.getText();

        if (txt.charAt(0) == '0' && digit.equals("0") ) {
            return;
        } else if (txt.charAt(0) == '0') {
            label.setText(digit);
        } else {
            label.setText(txt.concat(digit));
        }
    }

    public void enterPeriod() {
        String txt = label.getText();

        if (txt.indexOf(".") == -1) {
            enterDigit(".");
        }
    }
}
