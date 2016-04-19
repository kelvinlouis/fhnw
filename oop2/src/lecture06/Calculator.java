package ch.fhnw.oop2.lecture6;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

/**
 * Created by Kelvin on 05-Apr-16.
 */
public class Calculator extends Application {

    @Override
    public void start(Stage primaryStage) {
        String url = getClass().getResource("calculator.css").toExternalForm();

        GridPane gridPane = new GridPane();
        gridPane.setHgap(1);
        gridPane.setVgap(1);

        gridPane.add(getLabel("0"), 0, 0, 4, 1);
        gridPane.add(getButton("C"), 0, 1);
        gridPane.add(getButton("+/-"), 1, 1);
        gridPane.add(getButton("/"), 2, 1);
        gridPane.add(getButton("*"), 3, 1);
        gridPane.add(getButton("7"), 0, 2);
        gridPane.add(getButton("8"), 1, 2);
        gridPane.add(getButton("9"), 2, 2);
        gridPane.add(getButton("-"), 3, 2);
        gridPane.add(getButton("4"), 0, 3);
        gridPane.add(getButton("5"), 1, 3);
        gridPane.add(getButton("6"), 2, 3);
        gridPane.add(getButton("+"), 3, 3);
        gridPane.add(getButton("1"), 0, 4);
        gridPane.add(getButton("2"), 1, 4);
        gridPane.add(getButton("3"), 2, 4);
        gridPane.add(getButton("="), 3, 4, 1, 2);
        gridPane.add(getButton("0"), 0, 5, 2, 1);
        gridPane.add(getButton("."), 2, 5);

        Scene scene = new Scene(gridPane);
        scene.getStylesheets().add(url);

        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private Button getButton(String name) {
        Button button = new Button(name);
        button.setPrefSize(30, 30);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        button.setAlignment(Pos.CENTER);
        GridPane.setHgrow(button, Priority.ALWAYS);
        GridPane.setVgrow(button, Priority.ALWAYS);
        return button;
    }

    private Label getLabel(String name) {
        Label label = new Label(name);
        label.setPrefSize(200, 50);
        label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        return label;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
