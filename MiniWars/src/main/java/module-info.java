module com.example.miniwars {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.example.miniwars to javafx.fxml;
    exports com.example.miniwars;
}