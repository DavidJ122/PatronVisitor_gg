package org.example.demo.Model;


import org.example.demo.Visitor.ShapeVisitor;

/**
 * Triángulo definido por sus tres lados (a,b,c) y además base y altura
 * (separados para que el área sea fácil de explicar).
 */
public class Triangulo implements ShapeElement {
    private final double a, b, c;      // lados
    private final double base, height; // para área

    public Triangulo(double a, double b, double c, double base, double height) {
        this.a = a; this.b = b; this.c = c;
        this.base = base; this.height = height;
    }

    public double getA() { return a; }
    public double getB() { return b; }
    public double getC() { return c; }
    public double getBase() { return base; }
    public double getHeight() { return height; }

    @Override
    public <T> T accept(ShapeVisitor<T> visitor) {
        return visitor.visitTriangle(this);
    }

    @Override
    public String toString() {
        return "Triángulo (lados=" + a + "," + b + "," + c + " | base=" + base + ", altura=" + height + ")";
    }
}
