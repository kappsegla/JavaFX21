package se.iths.shapes.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import se.iths.shapes.Shape;

import java.util.Arrays;

public final class Triangle extends Shape {
    double[] xcoords = new double[3];
    double[] ycoords = new double[3];

    public Triangle(Color color, double[] x, double[] y) {
        super(color,x[0],y[0]);
        xcoords = Arrays.copyOf(x,x.length);
        ycoords = Arrays.copyOf(y,y.length);
    }

    public Triangle(Color color, double x, double y) {
        super(color, x, y);

        xcoords[0] = getX();
        ycoords[0] = getY();
        xcoords[1] = getX()+5;
        ycoords[1] = getY() + 10;
        xcoords[2] = getX()-5;
        ycoords[2] = getY() + 10;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(getColor());
        graphicsContext.fillPolygon(xcoords,ycoords,3);
    }

    @Override
    public boolean isInside(double x, double y) {
        return false;
    }
}
