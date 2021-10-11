module se.iths.java21.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens se.iths.java21.javafx to javafx.fxml;
    exports se.iths.java21.javafx;
}