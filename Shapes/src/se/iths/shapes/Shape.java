package se.iths.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import se.iths.shapes.shapes.Circle;
import se.iths.shapes.shapes.Rectangle;

//*Göra Shape abstract superklass för att representera en shape
//*Skapa subklass Circle
//Skapa subklass Rectangle
//Immutable
//*Definiera en metod som kan rendera objektet med javafx.
//*Gör specifika implementationer i subklasser (Polymorfism)
//*Hindra användare att skapa Circle objekt utan att gå via våra factory metoder på klassen Shapes

//*Hindra arv av Shape?  sealed types

public abstract sealed class Shape permits Circle, Rectangle, se.iths.shapes.shapes.Triangle {
    private Color color;
    private double x;
    private double y;

    public Shape(Color color, double x, double y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public abstract void draw(GraphicsContext graphicsContext);

    public abstract boolean isInside(double x, double y);


    public Color getColor() {
        return color;
    }

    public Shape setColor(Color color) {
        this.color = color;
        return this;
    }

    public double getX() {
        return x;
    }

    public Shape setX(double x) {
        this.x = x;
        return this;
    }

    public double getY() {
        return y;
    }

    public Shape setY(double y) {
        this.y = y;
        return this;
    }
}
