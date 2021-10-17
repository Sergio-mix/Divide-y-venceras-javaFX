package co.edu.unbosque.view;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Components {
    public Components() {

    }

    @FXML
    public static Text text(Object t) {
        Text text = new Text();
        text.setText(String.valueOf(t));
        text.setFill(Color.web("#313131FF"));
        text.setStyle(
                " -fx-font-size: 26px;" +
                        "-fx-font-family: Arial;"
        );

        return text;
    }


    @FXML
    public static HBox hbox() {
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(30);
        hBox.setPadding(new Insets(0, 20, 0, 20));
        hBox.setStyle(
                "-fx-border-radius: 15 15 15 15;" +
                        " -fx-background-color: #eeeeee;" +
                        " -fx-effect: dropshadow(gaussian, rgb(35,35,35), 8, 0.5, 0.0, 0.0);" +
                        "-fx-pref-height:50px;" +
                        "-fx-pref-white:50px;" +
                        "-fx-background-radius:15 15 15 15;"
        );

        return hBox;
    }

    @FXML
    public static HBox hbox(Object ob) {
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().add((Node) ob);
        hBox.setSpacing(30);
        hBox.setStyle(
                "-fx-pref-white:50px;"
        );

        return hBox;
    }

    public static GridPane gridPane() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(0, 20, 0, 20));
        gridPane.setStyle(
                "-fx-border-color: #313131;" +
                        " -fx-effect: dropshadow(gaussian, rgb(109,108,108), 5, 0.5, 0.0, 0.0);" +
                        "-fx-stroke-dash-offset: 3;" +
                        "-fx-border-style: solid;" +
                        " -fx-border-width: 0 5 0 5; ");

        return gridPane;
    }

}
