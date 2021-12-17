module gnosis{
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires java.sql;
    requires sqlite.jdbc;
    requires java.desktop;

    opens com.example.gnosis to javafx.fxml;
    exports com.example.gnosis;
    opens com.example.gnosis.module;
    opens com.example.gnosis.database;
    exports com.example.gnosis.module;
    exports com.example.gnosis.database;
}
