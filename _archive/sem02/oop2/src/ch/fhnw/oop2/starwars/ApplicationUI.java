package ch.fhnw.oop2.starwars;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.StackPane;

/**
 * the application user interface
 */
public class ApplicationUI
        extends StackPane
        implements ApplicationView {

    private final Presenter presenter;
    private ListView<String> listView;

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

    @Override
    public void setStarWarsMovies(List<String> movies) {
        listView.setItems(FXCollections.observableArrayList(movies));
        listView.getSelectionModel().select(0);
    }

    private void initializeControls() {
        listView = new ListView<>();
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listView.setCellFactory(e -> new MyListCell());
    }

    private void layoutControls() {
        getChildren().add(listView);
    }

    private void addEventHandlers() {

    }

    private void addValueChangeListeners() {
        listView.getSelectionModel().selectedIndexProperty().addListener((ob, ov, nv) -> {
            System.out.println(listView.getItems().get(nv.intValue()));
        });
    }

    private void addBindings() {
    }
}
