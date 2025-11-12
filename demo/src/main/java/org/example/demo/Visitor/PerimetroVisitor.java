package org.example.demo.Visitor;

import org.example.demo.Model.Circulo;
import org.example.demo.Model.Rectangulo;
import org.example.demo.Model.Triangulo;

public class PerimetroVisitor implements ShapeVisitor<Double> {
    @Override
    public Double visitCircle(Circulo c) {
        return 2 * Math.PI * c.getRadius();
    }

    @Override
    public Double visitRectangle(Rectangulo r) {
        return 2 * (r.getWidth() + r.getHeight());
    }

    @Override
    public Double visitTriangle(Triangulo t) {
        return t.getA() + t.getB() + t.getC();
    }
}
