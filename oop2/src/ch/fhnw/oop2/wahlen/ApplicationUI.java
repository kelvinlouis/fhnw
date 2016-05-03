package ch.fhnw.oop2.wahlen;

import java.util.List;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * the application user interface
 */
public class ApplicationUI
        extends VBox
        implements ApplicationView {

    private final Presenter presenter;
    private TableView<Result> tableView;
    private Label label;

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
    public void setResults(List<Result> results) {
        ObservableList<Result> observableList
                = FXCollections.observableArrayList();
        observableList.addAll(results);
        tableView.setItems(observableList);

        TableColumn<Result, String> nameColumn = new TableColumn<>("Gemeinde");
        tableView.getColumns().add(nameColumn);
        nameColumn.setCellValueFactory(e -> new ReadOnlyObjectWrapper<>(
                e.getValue().getCommunityName()
        ));

        TableColumn<Result, String> canton = new TableColumn<>("Kanton");
        tableView.getColumns().add(canton);
        canton.setCellValueFactory(e -> new ReadOnlyObjectWrapper<>(
                e.getValue().getCanton()
        ));

        TableColumn<Result, Integer> allowed = new TableColumn<>("Wahlberechtigte");
        tableView.getColumns().add(allowed);
        allowed.setCellValueFactory(e -> new ReadOnlyObjectWrapper<>(
                e.getValue().getEligibleVoters()
        ));

        TableColumn<Result, Integer> voters = new TableColumn<>("Wähler");
        tableView.getColumns().add(voters);
        voters.setCellValueFactory(e -> new ReadOnlyObjectWrapper<>(
                e.getValue().getEligibleVoters()
        ));

        TableColumn<Result, String> turnout = new TableColumn<>("Wahlbeteiligung");
        tableView.getColumns().add(turnout);
        turnout.setCellValueFactory(e -> new ReadOnlyObjectWrapper<>(
                String.format("%f%s", 100 * e.getValue().getTurnout(), "%")
        ));
        
        label.setText(String.format("Wahlergebnisse der %d Gemeinden", results.size()));
    }

    private void initializeControls() {
        tableView = new TableView<>();
        label = new Label();
    }

    private void layoutControls() {
        getChildren().add(tableView);
        VBox.setVgrow(tableView, Priority.ALWAYS);
        getChildren().add(label);
    }

    private void addEventHandlers() {
    }

    private void addValueChangeListeners() {
    }

    private void addBindings() {
    }
}
