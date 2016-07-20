package ch.fhnw.oop2.testPrep.gui;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Kelvin on 05-Jul-16.
 */
public class Starter extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        String url = getClass().getResource("style.css").toExternalForm();

        Parent rootPanel = new ApplicationUI();
        Scene scene = new Scene(rootPanel, 400, 250);
        scene.getStylesheets().add(url);

        primaryStage.setTitle("Title");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * starts the program
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.setProperty("prism.lcdtext", "false");
        launch(args);
    }
}
