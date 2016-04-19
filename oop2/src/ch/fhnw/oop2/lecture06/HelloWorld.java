package ch.fhnw.oop2.lecture6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class HelloWorld extends Application {
    @Override
    public void start(Stage primaryStage) {
        System.out.println("START");

//        primaryStage.setScene(helloWorld());
//        primaryStage.setScene(rectangles());
//        primaryStage.setScene(vBox());
        primaryStage.setScene(threeButtons());
        primaryStage.show();
    }

    public Scene threeButtons() {
        HBox hbox = new HBox();
        hbox.setSpacing(2);
        hbox.setPadding(new Insets(20));

        Button b1 = new Button("first");
        Button b2 = new Button("second");
        Button b3 = new Button("third");

        b2.setPrefHeight(200);
        b2.setPrefWidth(200);
        b2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        hbox.setHgrow(b2, Priority.ALWAYS);

        hbox.getChildren().add(b1);
        hbox.getChildren().add(b2);
        hbox.getChildren().add(b3);

        return new Scene(hbox);
    }

    public Scene helloWorld() {
        Button button = new Button("Hello World");
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(button);

        stackPane.setStyle("-fx-background-color: blueviolet;");
        button.setStyle("-fx-font-weight: bold; -fx-font-size: 2em; -fx-background-color: red;");

        return new Scene(stackPane, 500, 350);
    }

    public Scene rectangles() {
        StackPane stackPane = new StackPane();

        Rectangle rectangle1 = new Rectangle(300, 300);
        rectangle1.setFill(Color.BLUE);
        stackPane.getChildren().add(rectangle1);

        Rectangle rectangle2 = new Rectangle(250, 250);
        rectangle2.setFill(Color.GREEN);
        stackPane.getChildren().add(rectangle2);

        Rectangle rectangle3 = new Rectangle(150, 150);
        rectangle3.setFill(Color.RED);
        rectangle3.setStrokeWidth(23.3);
        rectangle3.setCursor(Cursor.CROSSHAIR);
        stackPane.getChildren().add(rectangle3);

        return new Scene(stackPane, 700, 500);
    }

    public Scene vBox() {
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(20));
        vBox.setSpacing(5);
        addLabel(vBox, "First", Color.web("0xeb9592"));
        addLabel(vBox, "Second", Color.web("0xe9e792"));
        addLabel(vBox, "Third", Color.web("0x8fe692"));
        addLabel(vBox, "Fourth", Color.web("0x8fe8e9"));
        addLabel(vBox, "Fifth", Color.web("0x9396ea"));
        return new Scene(vBox);
    }

    private void addLabel(VBox vBox, String name, Color color) {
        Label label = new Label(name);
        BackgroundFill fill = new BackgroundFill(color, null, null);
        label.setBackground(new Background(fill));
        label.setPrefSize(100, 100);
        label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        label.setAlignment(Pos.CENTER);
        VBox.setVgrow(label, Priority.ALWAYS);
        vBox.getChildren().add(label);
    }

    @Override
    public void init() throws Exception {
        System.out.println("INIT");
        super.init();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("STOP");
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}