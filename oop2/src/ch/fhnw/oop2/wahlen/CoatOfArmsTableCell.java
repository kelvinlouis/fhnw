package ch.fhnw.oop2.wahlen;

import javafx.scene.control.TableCell;

/**
 * a TableCell that shows the coat of arms of a canton
 */
public class CoatOfArmsTableCell extends TableCell<Result, String> {

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        setGraphic(null);
        setText(null);
        if (item != null) {
            // TODO: load and show coat of arms
        }
    }
}
