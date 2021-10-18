module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;

    opens co.edu.unbosque.controller to javafx.fxml;
    opens co.edu.unbosque.model to javafx.fxml;
    exports co.edu.unbosque.controller;
    exports co.edu.unbosque.model;
    exports co.edu.unbosque.algorithm;
    opens co.edu.unbosque.algorithm to javafx.fxml;

}