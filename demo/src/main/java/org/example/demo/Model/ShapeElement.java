package org.example.demo.Model;


import org.example.demo.Visitor.ShapeVisitor;

public interface ShapeElement {
    <T> T accept(ShapeVisitor<T> visitor);
}
