package se.iths.shapes;

import javafx.scene.paint.Color;
import se.iths.shapes.shapes.Circle;

public class Shapes {

    public static Shape circleOf(double x, double y, double radius, Color color){
        return new Circle(color,x,y,radius);
    }

}
