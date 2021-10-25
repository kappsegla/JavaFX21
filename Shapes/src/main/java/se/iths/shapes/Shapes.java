package se.iths.shapes;

import javafx.scene.paint.Color;
import se.iths.shapes.shapes.Circle;
import se.iths.shapes.shapes.Rectangle;
import se.iths.shapes.shapes.Triangle;

public class Shapes {

    public static Shape circleOf(double x, double y, double radius, Color color) {
        return new Circle(color, x, y, radius);
    }

    public static Shape rectangleOf(double x, double y, double size, Color color) {
        return new Rectangle(color, x, y, size);
    }

    public static Shape triangleOf(double x, double y, Color color) {
        return new Triangle(color, x, y);
    }
    public static Shape triangleOf(double[] x, double[] y, Color color) {
        return new Triangle(color, x, y);
    }


}
