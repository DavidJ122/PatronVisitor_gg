package org.example.demo.Controller;

import org.example.demo.Model.*;
import org.example.demo.Visitor.AreaVisitor;
import org.example.demo.Visitor.DibujarVisitor;
import org.example.demo.Visitor.PerimetroVisitor;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

public class MainController {

    @FXML private ListView<ShapeElement> listViewShapes;
    @FXML private Label lblResultado;
    @FXML private Pane canvasPane;

    @FXML
    public void initialize() {
        // Muestras de datos (fáciles de explicar)
        listViewShapes.getItems().addAll(
                new Circulo(60),            // radio = 60
                new Rectangulo(160, 90),    // ancho=160, alto=90
                new Triangulo(120, 80, 130, 120, 70) // a,b,c y base/altura
        );

        listViewShapes.setCellFactory(lv -> new ListCell<>() {
            @Override protected void updateItem(ShapeElement item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.toString());
            }
        });

        lblResultado.setText("Selecciona una figura y una operación.");
    }

    @FXML
    public void onCalcularArea() {
        ShapeElement sel = listViewShapes.getSelectionModel().getSelectedItem();
        if (sel == null) { showInfo("Elige una figura."); return; }
        double area = sel.accept(new AreaVisitor());
        lblResultado.setText("Área = " + format(area));
    }

    @FXML
    public void onCalcularPerimetro() {
        ShapeElement sel = listViewShapes.getSelectionModel().getSelectedItem();
        if (sel == null) { showInfo("Elige una figura."); return; }
        double per = sel.accept(new PerimetroVisitor());
        lblResultado.setText("Perímetro = " + format(per));
    }

    @FXML
    public void onDibujar() {
        ShapeElement sel = listViewShapes.getSelectionModel().getSelectedItem();
        if (sel == null) { showInfo("Elige una figura."); return; }
        canvasPane.getChildren().clear();
        Node n = sel.accept(new DibujarVisitor(canvasPane.getWidth(), canvasPane.getHeight()));
        canvasPane.getChildren().add(n);
        lblResultado.setText("Dibujado con DrawVisitor.");
    }

    @FXML
    public void onLimpiar() {
        canvasPane.getChildren().clear();
        lblResultado.setText("Lienzo limpio.");
    }

    private void showInfo(String msg) {
        new Alert(Alert.AlertType.INFORMATION, msg, ButtonType.OK).showAndWait();
    }

    private String format(double v) {
        return String.format("%.2f", v);
    }
}
