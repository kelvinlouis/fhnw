package ch.fhnw.oop2.lecture09;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

/**
 * Created by Kelvin on 26-Apr-16.
 */
public class Lecture09 {
    public static void main(String[] args) {
        ObservableList<String> myList = FXCollections.observableArrayList();
        myList.addListener((ListChangeListener.Change<? extends String> change) -> {
            while (change.next()) {
                if (change.wasAdded()) {
                    change.getAddedSubList().forEach(s -> System.out.printf("Added: %s %n", s));
                } else if (change.wasRemoved()) {
                    change.getRemoved().forEach(s -> System.out.printf("Removed: %s %n", s));
                }
            }
        });

        myList.add("erster Eintrag");
        myList.add("zweiter Eintrag");
        myList.add("dritter Eintrag");

        myList.remove(0,2);
    }
}
