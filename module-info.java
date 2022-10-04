module Persistencia1.GUIFX {
    requires javafx.base;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.logging;
    requires javafx.graphics;

    exports controllers to javafx.fxml;
    opens application to javafx.graphics, javafx.fxml;
    exports application;
}