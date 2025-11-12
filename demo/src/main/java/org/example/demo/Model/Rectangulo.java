package org.example.demo.Model;


import org.example.demo.Visitor.ShapeVisitor;

public class Rectangulo implements ShapeElement {
    private final double width;
    private final double height;

    public Rectangulo(double width, double height) {
        this.width = width; this.height = height;
    }
    public double getWidth() { return width; }
    public double getHeight() { return height; }

    @Override
    public <T> T accept(ShapeVisitor<T> visitor) {
        return visitor.visitRectangle(this);
    }

    @Override
    public String toString() {
        return "Rectángulo (" + width + " x " + height + ")";
    }
}
