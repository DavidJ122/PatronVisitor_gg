package org.example.demo.Visitor;

import org.example.demo.Model.Circulo;
import org.example.demo.Model.Rectangulo;
import org.example.demo.Model.Triangulo;

public class AreaVisitor implements ShapeVisitor<Double> {
    @Override
    public Double visitCircle(Circulo c) {
        return Math.PI * c.getRadius() * c.getRadius();
    }

    @Override
    public Double visitRectangle(Rectangulo r) {
        return r.getWidth() * r.getHeight();
    }

    @Override
    public Double visitTriangle(Triangulo t) {
        return 0.5 * t.getBase() * t.getHeight();
    }
}
