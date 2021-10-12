package se.iths.java21.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class HelloController {

    public TextField textField1;
    @FXML
    private Label welcomeText;

    @FXML
    private CheckBox checkBox1;

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
        System.out.println(keyEvent.getCharacter());
        String text = textField1.getText();
        if (text.length() > 5)
            textField1.setText(text.substring(0, text.length() - 1));
    }
}