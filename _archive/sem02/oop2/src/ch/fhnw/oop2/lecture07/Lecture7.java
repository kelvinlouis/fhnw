package ch.fhnw.oop2.lecture07;/**
 * Created by Kelvin on 12-Apr-16.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Lecture7 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox vbox = new ApplicationUI();

        primaryStage.setTitle("Java :(");
        primaryStage.setScene(new Scene(vbox, 150, 75));
        primaryStage.show();

        initListeners(primaryStage);
    }

    private void initListeners(Stage primaryStage) {
        primaryStage.setOnCloseRequest(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "CLOSE ME?", ButtonType.CLOSE);
            alert.setContentText("CLOSE ME?");
            alert.showAndWait().filter(b -> b == ButtonType.CLOSE);
        });
    }
}
