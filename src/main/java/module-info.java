module org.example {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.unbosque.controller to javafx.fxml;
    exports co.edu.unbosque.controller;

}