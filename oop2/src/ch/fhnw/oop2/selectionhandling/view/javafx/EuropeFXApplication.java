package ch.fhnw.oop2.selectionhandling.view.javafx;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * the Europe FX application
 */
public class EuropeFXApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        Parent parent = new EuropeFXView();
        Scene scene = new Scene(parent);
        String url = getClass().getResource("europe.css").toExternalForm();
        scene.getStylesheets().add(url);
        primaryStage.setTitle("Selection Handling");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.setProperty("prism.lcdtext", "false");
        launch(args);
    }
}
