module Gnosis{
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires sqlite.jdbc;

    opens id.ac.ukdw.fti.rpl.Gnosis to javafx.fxml;
    exports id.ac.ukdw.fti.rpl.Gnosis.database;
    exports id.ac.ukdw.fti.rpl.Gnosis.modal;
    exports id.ac.ukdw.fti.rpl.Gnosis;
}