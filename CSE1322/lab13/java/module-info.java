module lab13 {
    requires javafx.controls;
    requires javafx.fxml;


    opens lab13 to javafx.fxml;
    exports lab13;
}