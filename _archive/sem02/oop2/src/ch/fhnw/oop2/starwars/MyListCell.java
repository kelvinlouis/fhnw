package ch.fhnw.oop2.starwars;

import javafx.scene.control.ListCell;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;

/**
 * Created by Kelvin on 26-Apr-16.
 */
public class MyListCell extends ListCell<String> {
    private final Random random;
    public MyListCell() {
        random = new Random();
    }
    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        setGraphic(null);
        setText(null);
        if (item != null) {
            Color randomColor = new Color(
                    random.nextDouble(),
                    random.nextDouble(),
                    random.nextDouble(), 1.0);
            setGraphic(new Circle(10, randomColor));
            setText(item);
        }
    }
}