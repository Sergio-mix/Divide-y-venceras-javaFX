package co.edu.unbosque.components;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ObjectView {
    public ObjectView() {

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
    public static Text text(String color, Object t, String size) {
        Text text = new Text();
        text.setText(String.valueOf(t));
        text.setFill(Color.web(color));
        text.setStyle(
                " -fx-font-size: " + size + ";" +
                        "-fx-font-family: Arial;"
        );

        return text;
    }

    @FXML
    public static HBox hBox() {
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
    public static HBox hBox(Object ob) {
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().add((Node) ob);
        hBox.setSpacing(30);
        hBox.setStyle(
                "-fx-pref-white:50px;"
        );

        return hBox;
    }

    @FXML
    public static HBox hBox_v2() {
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(100);

        return hBox;
    }

    @FXML
    public static VBox vBox() {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(25);

        return vBox;
    }

    @FXML
    public static VBox vBox(Integer spacing) {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(spacing);

        return vBox;
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

    public static GridPane gridPane_v2() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(50);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(0, 20, 0, 20));
        gridPane.setStyle(
                " -fx-effect: dropshadow(gaussian, rgb(109,108,108), 2, 0.5, 0.0, 0.0);"
        );

        return gridPane;
    }

}
