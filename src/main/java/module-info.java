module com.casachristo.formexample {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.casachristo.formexample to javafx.fxml;
    exports com.casachristo.formexample;
    exports controller;
    opens controller to javafx.fxml;
}