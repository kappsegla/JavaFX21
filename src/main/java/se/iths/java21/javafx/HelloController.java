package se.iths.java21.javafx;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;

import java.util.function.UnaryOperator;

public class HelloController {

    public TextField textField1;
    public Canvas canvas;
    @FXML
    private Label welcomeText;

    @FXML
    private CheckBox checkBox1;

    public void initialize() {
        textField1.setText("Hej");
        UnaryOperator<TextFormatter.Change> filter = change -> {

            if(change.getText().equals("a"))
                change.setText("Hej");
            else
                change.setText("");
            return change ;
        };

        TextFormatter<String> formatter = new TextFormatter<>(TextFormatter.IDENTITY_STRING_CONVERTER,"",filter);
        textField1.setTextFormatter(formatter);

    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void onCheckBoxChecked() {
        welcomeText.setText("Checkbox: " + checkBox1.isSelected());
    }

    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println(mouseEvent.getX() + ":" + mouseEvent.getY());
        System.out.println(mouseEvent.getSceneX() + ":" + mouseEvent.getSceneY());
        System.out.println(mouseEvent.getScreenX() + ":" + mouseEvent.getScreenY());
    }

    public void keyTyped(KeyEvent keyEvent) {
//        System.out.println(keyEvent.getCharacter());
//        String text = textField1.getText();
//        if (text.length() > 5)
//            textField1.setText(text.substring(0, text.length() - 1));
    }

    public void canvasClicked(MouseEvent event) {
        System.out.println("Clicked on canvas");
        var context = canvas.getGraphicsContext2D();
        context.fillOval(event.getX(),event.getY(),25,25);
    }
}