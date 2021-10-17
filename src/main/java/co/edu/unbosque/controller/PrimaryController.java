package co.edu.unbosque.controller;

import java.net.URL;
import java.util.*;

import co.edu.unbosque.model.Matriz;
import co.edu.unbosque.view.Components;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class PrimaryController implements Initializable {


    @FXML
    private Label buttonPane1;

    @FXML
    private Label buttonPane2;

    @FXML
    private Pane pane1;

    @FXML
    private Pane pane2;

    @FXML
    private VBox vBoxPanel1;

    @FXML
    private HBox hBoxPanel2;

    @FXML
    private TextField txtBusqueda;

    @FXML
    private TextField txtTamanio;

    @FXML
    private TextField txtColumnaMatriz1;

    @FXML
    private TextField txtColumnaMatriz2;

    @FXML
    private TextField txtFilaMatris1;

    @FXML
    private TextField txtFilaMatris2;

    private static Matriz matriz;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonPane2.setStyle("-fx-text-fill: #787575;");
        buttonPane1.setStyle("-fx-text-fill: #ffffff;");

        txtBusqueda.addEventFilter(KeyEvent.ANY, handlerNumbers);
        txtTamanio.addEventFilter(KeyEvent.ANY, handlerNumbers);
        txtColumnaMatriz1.addEventFilter(KeyEvent.ANY, handlerNumbers);
        txtColumnaMatriz2.addEventFilter(KeyEvent.ANY, handlerNumbers);
        txtFilaMatris1.addEventFilter(KeyEvent.ANY, handlerNumbers);
        txtFilaMatris2.addEventFilter(KeyEvent.ANY, handlerNumbers);
    }

    @FXML
    private void pane1() {
        pane2.setVisible(false);
        pane1.setVisible(true);
        buttonPane2.setStyle("-fx-text-fill: #787575;");
        buttonPane1.setStyle("-fx-text-fill: #ffffff;");
    }

    @FXML
    private void pane2() {
        pane1.setVisible(false);
        pane2.setVisible(true);
        buttonPane1.setStyle("-fx-text-fill: #787575;");
        buttonPane2.setStyle("-fx-text-fill: #ffffff;");
    }

    @FXML
    private void busquedaBinaria() throws NumberFormatException {
        vBoxPanel1.getChildren().clear();

        int n = Integer.parseInt(txtTamanio.getText());
        int b = Integer.parseInt(txtBusqueda.getText());

        int[] a = Methods.numerosAleatorios(n);

        HBox hBox = Components.hbox();

        for (int i = 0; i < n; i++) {
            hBox.getChildren().add(Components.text(a[i]));
        }

        addBOX(hBox);

        localiza(a, b, 0, n - 1);
    }

    public Integer localiza(int[] a, int busqueda, int izquierda, int derecha) {
        try {
            int i;

            if (busqueda == a[izquierda]) {
                addBOX(Components.text(busqueda + " = " + a[izquierda]));
                addBOX(Components.text("Elemento en la posición: " + izquierda));
                return izquierda;
            }

            if (busqueda == a[derecha]) {
                addBOX(Components.text(busqueda + " = " + a[derecha]));
                addBOX(Components.text("Elemento en la posición: " + derecha));
                return derecha;
            }

            if (izquierda > derecha) {
                addBOX(Components.text("No se encontro el elemento: " + busqueda));
                return null;
            }

            i = (izquierda + derecha + 1) / 2;

            if (busqueda == a[i]) {
                addBOX(Components.text(busqueda + " = " + a[i]));

                addBOX(Components.hbox(Components.hbox(a[i])));

                addBOX(Components.text("Elemento en la posición: " + i));

                return i;

            } else if (busqueda < a[i]) {
                addBOX(Components.text(busqueda + " < " + a[i]));

                HBox hBox = Components.hbox();

                for (int n = 1; n < i; n++) {
                    hBox.getChildren().add(Components.text(a[n]));
                }

                addBOX(Components.hbox(hBox));

                return localiza(a, busqueda, 1, i - 1);

            } else if (busqueda > a[i]) {
                addBOX(Components.text(busqueda + " > " + a[i]));

                HBox hBox = Components.hbox();

                for (int n = i; n < derecha; n++) {
                    hBox.getChildren().add(Components.text(a[n]));
                }

                addBOX(Components.hbox(hBox));

                return localiza(a, busqueda, i + 1, derecha);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @FXML
    private void addBOX(Object ob) {
        vBoxPanel1.getChildren().add((Node) ob);
    }

    @FXML
    public void multiplicacionMatriz() {
        hBoxPanel2.getChildren().clear();

        int f1 = Integer.parseInt(txtFilaMatris1.getText());
        int c1 = Integer.parseInt(txtColumnaMatriz1.getText());
        int f2 = Integer.parseInt(txtFilaMatris2.getText());
        int c2 = Integer.parseInt(txtColumnaMatriz2.getText());

        if (c1 == f2) {
            int[][] m1 = new int[f1][c1];
            int[][] m2 = new int[f2][c2];
            int[][] mR = new int[f1][c2];
            matriz = new Matriz(m1, m2, mR);

            for (int i = 0; i < f1; i++) {
                for (int j = 0; j < c1; j++) {
                    m1[i][j] = Methods.numeroAleatorio();
                    matriz.setM1(m1);
                }
            }

            for (int i = 0; i < f2; i++) {
                for (int j = 0; j < c2; j++) {
                    m2[i][j] = Methods.numeroAleatorio();
                    matriz.setM2(m2);
                }

            }

            GridPane gridPane1 = Components.gridPane();
            for (int i = 0; i < f1; i++) {
                for (int j = 0; j < c1; j++) {
                    gridPane1.add(Components.text(matriz.getM1()[i][j]), i, j);
                }
            }

            addMatris(gridPane1);

            Text t1 = Components.text("X");
            t1.setFill(Color.web("#FC4C00FF"));
            t1.setStyle("-fx-font-size: 50px;");
            addMatris(t1);

            GridPane gridPane2 = Components.gridPane();
            for (int i = 0; i < f2; i++) {
                for (int j = 0; j < c2; j++) {
                    gridPane2.add(Components.text(matriz.getM2()[i][j]), i, j);
                }
            }

            addMatris(gridPane2);

            Text t2 = Components.text("=");
            t2.setFill(Color.web("#1FCD7FFF"));
            t2.setStyle("-fx-font-size: 60px;");
            addMatris(t2);

            GridPane gridPane3 = Components.gridPane();
            for (int i = 0; i < f1; i++) {
                for (int j = 0; j < c2; j++) {
                    for (int h = 0; h < c1; h++) {
                        mR[i][j] += m1[i][h] * m2[h][j];
                    }
                    matriz.setmR(mR);
                    gridPane3.add(Components.text(matriz.getmR()[i][j]), i, j);
                }
            }

            addMatris(gridPane3);
        } else {
            addMatris(Components.text("la operacion no se puede realizar"));
        }
    }

    @FXML
    private void addMatris(Object ob) {
        hBoxPanel2.getChildren().add((Node) ob);
    }

    EventHandler<KeyEvent> handlerNumbers = new EventHandler<KeyEvent>() {
        private boolean willConsume = false;

        @Override
        public void handle(KeyEvent event) {
            if (willConsume) {
                event.consume();
            }
            if (!event.getText().matches("[0-9]") && event.getCode() != KeyCode.BACK_SPACE) {
                if (event.getEventType() == KeyEvent.KEY_PRESSED) {
                    willConsume = true;
                } else if (event.getEventType() == KeyEvent.KEY_RELEASED) {
                    willConsume = false;
                }
            }
        }
    };

}
