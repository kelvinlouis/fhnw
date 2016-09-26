package ch.fhnw.oop2.testPrep.gui;

import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * Created by Kelvin on 05-Jul-16.
 */
public class ApplicationUI extends StackPane implements ApplicationView {

    private final Presenter presenter;
    private VBox layers;
    private TopView topView;
    private BottomView bottomView;

    public ApplicationUI() {
        presenter = new Presenter(this);
        layers = new VBox();
        getChildren().add(layers);

        initializeTopView();
        initializeBottomView();

        setId("main");
        //setStyle("-fx-background-color: yellow");
        //getStyleClass().addAll("country-poster", "country");
    }

    private void initializeTopView() {
        topView = new TopView();
        addRegion(topView);
    }

    private void initializeBottomView() {
        bottomView = new BottomView();
        addRegion(bottomView);
    }

    private void addRegion(Region region) {
        VBox.setVgrow(region, Priority.ALWAYS);
        region.setMaxWidth(Double.MAX_VALUE);
        layers.getChildren().add(region);
    }
}
