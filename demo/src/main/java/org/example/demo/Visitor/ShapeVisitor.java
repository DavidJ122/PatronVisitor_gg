package org.example.demo.Visitor;

import org.example.demo.Model.Circulo;
import org.example.demo.Model.Rectangulo;
import org.example.demo.Model.Triangulo;

public interface ShapeVisitor<T> {
    T visitCircle(Circulo c);
    T visitRectangle(Rectangulo r);
    T visitTriangle(Triangulo t);
}
