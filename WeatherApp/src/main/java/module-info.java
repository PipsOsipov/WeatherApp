module com.pips_corp.weatherapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires org.json;

    opens com.pips_corp.weatherapp to javafx.fxml;
    exports com.pips_corp.weatherapp;
}