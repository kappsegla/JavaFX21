package se.iths.java21.javafx;

import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import se.iths.shapes.Shape;
import se.iths.shapes.Shapes;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Model {

    private final StringProperty text;
    private final BooleanProperty inColor;
    private final ObjectProperty<Color> color;

    ObservableList<String> observableList =
            FXCollections.observableArrayList();

    ObservableList<Shape> shapes =
            FXCollections.observableArrayList();

    //List<Shape> shapes = new ArrayList<>();

    double[] xcoords = new double[3];
    double[] ycoords = new double[3];
    int clickCounter = 0;


    public Model() {
        this.text = new SimpleStringProperty("");
        this.inColor = new SimpleBooleanProperty();
        this.color = new SimpleObjectProperty<>(Color.BLACK);
    }

    public Color getColor() {
        return color.get();
    }

    public ObjectProperty<Color> colorProperty() {
        return color;
    }

    public void setColor(Color color) {
        this.color.set(color);
    }

    public boolean isInColor() {
        return inColor.get();
    }

    public BooleanProperty inColorProperty() {
        return inColor;
    }

    public void setInColor(boolean inColor) {
        this.inColor.set(inColor);
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

    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;
    public BooleanProperty connected = new SimpleBooleanProperty();
    ExecutorService executorService = Executors.newSingleThreadExecutor();

    public void connect() {
        if( connected.get() )
            return;
        try{
            socket = new Socket("192.168.1.137", 8000);
            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output, true);

            InputStream input = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(input));
            connected.set(true);
            System.out.println("Connected to server");

            executorService.submit(this::networkHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendToServer(Shape shape) {
        if( connected.get() ) {
            writer.println("Created a new shape with coords, x:" + shape.getX() + " y:" + shape.getY());
        }
    }

    private void networkHandler() {
        try {
            while (true) {
                String line = reader.readLine();    // reads a line of text
                System.out.println(line);
                Platform.runLater(()->
                shapes.add(Shapes.circleOf(Math.random()*100,Math.random()*100,10.0,Color.PINK)));
            }
        } catch (IOException e) {
            System.out.println("I/O error. Disconnected.");
            Platform.runLater(()-> connected.set(false));
        }
    }
}
