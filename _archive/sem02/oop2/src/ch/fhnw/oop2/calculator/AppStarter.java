package ch.fhnw.oop2.calculator;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * the application starter
 */
public class AppStarter extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent rootPanel = new ApplicationUI();

        Scene scene = new Scene(rootPanel);
        String url = getClass().getResource("calculator.css").toExternalForm();
        scene.getStylesheets().add(url);
        
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * starts the program
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.setProperty("prism.lcdtext", "false");
        launch(args);
    }
}
