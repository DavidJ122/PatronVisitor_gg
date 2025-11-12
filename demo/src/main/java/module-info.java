module org.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    // Para que FXMLLoader pueda crear el controller por reflexión:
    opens org.example.demo.Controller to javafx.fxml;

    // Si usas clases del modelo en ListView/TableView, abre el paquete al binding:
    opens org.example.demo.Model to javafx.base;

    // Exporta el paquete donde está tu clase App (punto de entrada)
    exports org.example.demo;
}
