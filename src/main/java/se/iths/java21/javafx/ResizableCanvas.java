package se.iths.java21.javafx;

import javafx.scene.canvas.Canvas;

public class ResizableCanvas extends Canvas {

    @Override
    public boolean isResizable() {
        return true;
    }

    @Override
    public double minHeight(double v) {
        return 1;
    }

    @Override
    public double minWidth(double v) {
        return 1;
    }
}
