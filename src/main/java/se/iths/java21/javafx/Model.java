package se.iths.java21.javafx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {

    private final StringProperty text;

    ObservableList<String> observableList =
            FXCollections.observableArrayList();

    public Model() {
        this.text = new SimpleStringProperty();
    }

    public String getText() {
        return text.getValue();
    }

    public void setText(String text) {
        this.text.setValue(text);
    }

    public StringProperty textProperty() {
        return text;
    }
}
