package se.iths.java21.javafx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.function.UnaryOperator;

public class HelloController {

    Model model;

    public TextField textField1;
    public Canvas canvas;
    @FXML
    private Label welcomeText;
    @FXML
    private CheckBox checkBox1;
    @FXML
    private ListView<String> listView1;

    public HelloController() {
    }

    public HelloController(Model model) {
        this.model = model;
    }

    public void initialize() {
        model = new Model();
        model.textProperty().bindBidirectional(textField1.textProperty());
        welcomeText.textProperty().bind(model.textProperty());

        textField1.disableProperty().bind(checkBox1.selectedProperty().not());

        model.observableList.add("Ett");
        model.observableList.add("Två");
        model.observableList.add("Tre");

        listView1.setItems( model.observableList);
        listView1.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> ov,
                                        String old_val, String new_val) {
                       model.setText(new_val);
                    }
                });
    }

    @FXML
    protected void onHelloButtonClick() {
        model.setText("Button pressed");
    }

    public void onCheckBoxChecked() {

    }

    public void mouseClicked(MouseEvent mouseEvent) {
        model.setText("");


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