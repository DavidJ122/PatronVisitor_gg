package org.example.demo.Visitor;

import org.example.demo.Model.Circulo;
import org.example.demo.Model.Rectangulo;
import org.example.demo.Model.Triangulo;
import javafx.scene.Node;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

/**
 * Devuelve un Node (forma JavaFX) para visualizar la figura.
 * Nota: Centramos más o menos cada figura en el lienzo.
 */
public class DibujarVisitor implements ShapeVisitor<Node> {

    private final double paneW;
    private final double paneH;

    public DibujarVisitor(double paneW, double paneH) {
        this.paneW = paneW;
        this.paneH = paneH;
    }

    @Override
    public Node visitCircle(Circulo c) {
        Circle circle = new Circle();
        circle.setRadius(c.getRadius());
        circle.setCenterX(paneW / 2);
        circle.setCenterY(paneH / 2);
        circle.setStyle("-fx-fill: transparent; -fx-stroke: #2b6cb0; -fx-stroke-width: 3;");
        return circle;
    }

    @Override
    public Node visitRectangle(Rectangulo r) {
        Rectangle rect = new Rectangle();
        rect.setWidth(r.getWidth());
        rect.setHeight(r.getHeight());
        rect.setX((paneW - r.getWidth()) / 2);
        rect.setY((paneH - r.getHeight()) / 2);
        rect.setStyle("-fx-fill: transparent; -fx-stroke: #38a169; -fx-stroke-width: 3;");
        return rect;
    }

    @Override
    public Node visitTriangle(Triangulo t) {
        double base = t.getBase();
        double height = t.getHeight();
        double x0 = (paneW - base) / 2;
        double y0 = (paneH + height) / 2;

        Polygon tri = new Polygon(
                x0, y0,                  // vértice izquierdo base
                x0 + base, y0,           // vértice derecho base
                x0 + base / 2, y0 - height // vértice superior
        );
        tri.setStyle("-fx-fill: transparent; -fx-stroke: #d69e2e; -fx-stroke-width: 3;");
        return tri;
    }
}
