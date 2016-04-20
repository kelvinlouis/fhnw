package ch.fhnw.oop2.calculator;

import ch.fhnw.oop2.calculator.operator.*;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/**
 * the application user interface (and even logic! :-P)
 */
public class ApplicationUI extends GridPane implements ApplicationView {

    private Label label;
    private Button clearButton;
    private Button signButton;
    private Button divideButton;
    private Button multiplyButton;
    private Button substractButton;
    private Button periodButton;
    private Button addButton;
    private Button equalButton;

    private final Presenter presenter;

    /**
     * creates a new ApplicationUI
     */
    public ApplicationUI() {
        initializeControls();
        layoutControls();
        addEventHandlers();
        addValueChangeListeners();
        addBindings();

        presenter = new Presenter(this);
    }

    private void initializeControls() {
        label = new Label("0");
        label.setId("label");
        clearButton = getButton("C");
        signButton = getButton("+/-");
        divideButton = getButton("/");
        multiplyButton = getButton("*");
        substractButton = getButton("-");
        addButton = getButton("+");
        periodButton = getButton(".");
        equalButton = getButton("=");
    }

    private void layoutControls() {
        label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        add(label, 0, 0, 4, 1);

        add(clearButton, 0, 1);
        add(signButton, 1, 1);
        add(divideButton, 2, 1);
        add(multiplyButton, 3, 1);
        add(getNumberButton("7"), 0, 2);
        add(getNumberButton("8"), 1, 2);
        add(getNumberButton("9"), 2, 2);
        add(substractButton, 3, 2);
        add(getNumberButton("4"), 0, 3);
        add(getNumberButton("5"), 1, 3);
        add(getNumberButton("6"), 2, 3);
        add(addButton, 3, 3);
        add(getNumberButton("1"), 0, 4);
        add(getNumberButton("2"), 1, 4);
        add(getNumberButton("3"), 2, 4);
        equalButton.getStyleClass().add("equal-button");
        add(equalButton, 3, 4, 1, 2);
        add(getNumberButton("0"), 0, 5, 2, 1);
        add(periodButton, 2, 5);
    }

    private void addEventHandlers() {

        setOnKeyTyped(e -> {
            String character = e.getCharacter();
            switch (e.getCharacter()) {
                case "0":
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                    presenter.enterDigit(character);
                    break;
                case ".":
                    presenter.enterPeriod();
                    break;
                case "+":
                    presenter.add();
                    break;
                case "-":
                    presenter.subtract();
                    break;
                case "*":
                    presenter.multiply();
                    break;
                case "/":
                    presenter.divide();
                    break;
                case "=":
                    presenter.calculate(null);
                    break;
            }
        });

        setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case BACK_SPACE:
                    presenter.removeLast();
                    break;
                case ENTER:
                    presenter.calculate(null);
                    break;
                case DELETE:
                    presenter.clear();
                    break;
            }
        });

        clearButton.setOnAction(e -> presenter.clear());
        signButton.setOnAction(e -> presenter.flipSign());
        periodButton.setOnAction(e -> presenter.enterPeriod());
        addButton.setOnAction(e -> presenter.add());
        substractButton.setOnAction(e -> presenter.subtract());
        multiplyButton.setOnAction(e -> presenter.multiply());
        divideButton.setOnAction(e -> presenter.divide());
        equalButton.setOnAction(e -> presenter.calculate(null));
    }

    private Button getNumberButton(String text) {
        Button button = getButton(text);
        button.setOnAction(e -> presenter.enterDigit(text));
        return button;
    }

    private Button getButton(String text) {
        Button button = new Button(text);
        button.setPrefSize(60, 60);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        button.setAlignment(Pos.CENTER);
        GridPane.setHgrow(button, Priority.ALWAYS);
        GridPane.setVgrow(button, Priority.ALWAYS);
        return button;
    }

    private void addValueChangeListeners() {
    }

    private void addBindings() {
    }
}
