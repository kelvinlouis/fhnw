package ch.fhnw.oop2.lecture7;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Created by Kelvin on 12-Apr-16.
 */
public class ApplicationUI extends VBox {
    private Label label;
    private Button button;
    private TextField textField;
    private Slider slider;

    public ApplicationUI() {
        initControls();
        initEventListeners();
        initPropertyListeners();
        initStyles();
    }

    private void initControls() {
        button = new Button("+1");
        button.setMaxWidth(Double.MAX_VALUE);

        textField = new TextField("0");
        slider = new Slider(0,100, 0);
        label = new Label();

        this.getChildren().add(label);
        this.getChildren().add(textField);
        this.getChildren().add(slider);
        this.getChildren().add(button);
    }

    private void initEventListeners() {
        StringProperty sp = textField.textProperty();

        button.setOnAction(event -> {
            sp.setValue(Integer.toString(Integer.parseInt(sp.getValue()) +1));
        });
    }

    private void initPropertyListeners() {
        DoubleProperty dp = slider.valueProperty();
        StringProperty sp = textField.textProperty();

        sp.addListener(observable -> {
            dp.setValue(Integer.parseInt(sp.getValue()));
        });

        dp.addListener((observable, oldValue, newValue) -> {
            sp.setValue(String.valueOf(newValue.intValue()));
        });

        label.textProperty().bind(dp.asString());
    }

    private void initStyles() {
        this.setPadding(new Insets(15, 15, 15, 15));
        this.setSpacing(5);
        this.setStyle("-fx-alignment: center");
    }

}
