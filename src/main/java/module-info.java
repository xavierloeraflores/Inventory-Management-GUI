module com.xavierloeraflores.inventorymanagement {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.xavierloeraflores.inventorymanagement to javafx.fxml;
    exports com.xavierloeraflores.inventorymanagement;
}