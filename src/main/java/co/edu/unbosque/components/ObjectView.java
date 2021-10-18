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

    /**
     * Objeto Text
     *
     * @param t Objeto agregado
     * @return Objeto Text con y agregado
     */
    @FXML
    public static Text text(Object t) {
        Text text = new Text();
        text.setText(String.valueOf(t));//add
        text.setFill(Color.web("#313131FF"));//Color
        text.setStyle(
                " -fx-font-size: 26px;" + //Tamanio letra
                        "-fx-font-family: Arial;" //Forma
        );

        return text;
    }

    /**
     * Objeto Text
     *
     * @param color color del texto
     * @param t     Objeto agregado
     * @param size  tamanio letra
     * @return Objeto Text con y agregado
     */
    @FXML
    public static Text text(String color, Object t, String size) {
        Text text = new Text();
        text.setText(String.valueOf(t));//add
        text.setFill(Color.web(color));//color
        text.setStyle(
                " -fx-font-size: " + size + ";" +//Tamanio letra
                        "-fx-font-family: Arial;"//Forma
        );

        return text;
    }

    /**
     * Objeto HBox
     *
     * @return Objeto HBox
     */
    @FXML
    public static HBox hBox() {
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);//Centrar
        hBox.setSpacing(30);//Espacio entre componentes
        hBox.setPadding(new Insets(0, 20, 0, 20));// distancia
        hBox.setStyle(
                "-fx-border-radius: 15 15 15 15;" +//Redondear
                        " -fx-background-color: #eeeeee;" +//Color
                        " -fx-effect: dropshadow(gaussian, rgb(35,35,35), 8, 0.5, 0.0, 0.0);" + //Sombra
                        "-fx-pref-height:50px;" +//Alto
                        "-fx-pref-white:50px;" +//Largo
                        "-fx-background-radius:15 15 15 15;"//Redondear
        );

        return hBox;
    }

    /**
     * Objeto HBox
     *
     * @param n Nodo agregado al HBox
     * @return Objeto HBox
     */
    @FXML
    public static HBox hBox(Node n) {
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);//Centrar
        hBox.getChildren().add(n);//add
        hBox.setSpacing(30);//Espacio
        hBox.setStyle(
                "-fx-pref-white:50px;"//Largo
        );

        return hBox;
    }

    /**
     * Objeto HBox version 2
     *
     * @return Objeto HBox
     */
    @FXML
    public static HBox hBox_v2() {
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);//Centrar
        hBox.setSpacing(100);//Espacio

        return hBox;
    }

    /**
     * Objeto VBox
     *
     * @return Objeto VBox
     */
    @FXML
    public static VBox vBox() {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);//Centrar
        vBox.setSpacing(25);//Espacio

        return vBox;
    }

    /**
     * Objeto VBox
     *
     * @param spacing //Espacio
     * @return Objeto VBox
     */
    @FXML
    public static VBox vBox(Integer spacing) {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);//Centrar
        vBox.setSpacing(spacing);//Espacio

        return vBox;
    }

    /**
     * Objeto GridPane
     *
     * @return Objeto GridPane
     */
    public static GridPane gridPane() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);//Centrar
        gridPane.setHgap(20);//Espacio vertical
        gridPane.setVgap(20);//Espacio Horizontal
        gridPane.setPadding(new Insets(0, 20, 0, 20));//Distancia componente interno
        gridPane.setStyle(
                "-fx-border-color: #313131;" +//Color de fondo
                        " -fx-effect: dropshadow(gaussian, rgb(109,108,108), 5, 0.5, 0.0, 0.0);" +//Sombra
                        "-fx-stroke-dash-offset: 3;" +//Borde
                        "-fx-border-style: solid;" +//Borde
                        " -fx-border-width: 0 5 0 5; ");//Borde

        return gridPane;
    }

    /**
     * Objeto GridPane version 2
     * @return Objeto GridPane
     */
    public static GridPane gridPane_v2() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);//Centrar
        gridPane.setHgap(50);//Espacio vertical
        gridPane.setVgap(20);//Espacio Horizontal
        gridPane.setPadding(new Insets(0, 20, 0, 20));//Distancia componente interno
        gridPane.setStyle(
                " -fx-effect: dropshadow(gaussian, rgb(109,108,108), 5, 0.5, 0.0, 0.0);"//Sombra
        );

        return gridPane;
    }

}
