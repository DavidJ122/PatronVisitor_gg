package org.example.demo.Model;


import org.example.demo.Visitor.ShapeVisitor;

public class Circulo implements ShapeElement {
    private final double radius;

    public Circulo(double radius) { this.radius = radius; }
    public double getRadius() { return radius; }

    @Override
    public <T> T accept(ShapeVisitor<T> visitor) {
        return visitor.visitCircle(this);
    }

    @Override
    public String toString() {
        return "Círculo (r=" + radius + ")";
    }
}
