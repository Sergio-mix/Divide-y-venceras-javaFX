package co.edu.unbosque.controller;

import java.net.URL;
import java.util.*;

import co.edu.unbosque.algorithm.BusquedaBinaria;
import co.edu.unbosque.model.Matriz;
import co.edu.unbosque.components.ObjectView;
import co.edu.unbosque.algorithm.MultiplicacionMatrizSimple;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class PrimaryController implements Initializable {


    @FXML
    private Label buttonPane1;

    @FXML
    private Label buttonPane2;

    @FXML
    private Label buttonPane3;

    @FXML
    private Pane pane1;

    @FXML
    private Pane pane2;

    @FXML
    private Pane pane3;

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
    private TextField txtColumnaMatriz3;

    @FXML
    private TextField txtFilaMatris1;

    @FXML
    private TextField txtFilaMatris2;

    @FXML
    private TextField txtFilaMatris3;

    @FXML
    private HBox hBoxPanel3;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            buttonPane2.setStyle("-fx-text-fill: #787575;");
            buttonPane1.setStyle("-fx-text-fill: #ffffff;");
            buttonPane3.setStyle("-fx-text-fill: #787575;");

            txtBusqueda.addEventFilter(KeyEvent.ANY, Methods.handlerNumbers);
            txtTamanio.addEventFilter(KeyEvent.ANY, Methods.handlerNumbers);
            txtColumnaMatriz1.addEventFilter(KeyEvent.ANY, Methods.handlerNumbers);
            txtColumnaMatriz2.addEventFilter(KeyEvent.ANY, Methods.handlerNumbers);
            txtFilaMatris1.addEventFilter(KeyEvent.ANY, Methods.handlerNumbers);
            txtFilaMatris2.addEventFilter(KeyEvent.ANY, Methods.handlerNumbers);
            txtColumnaMatriz3.addEventFilter(KeyEvent.ANY, Methods.handlerNumbers);
            txtFilaMatris3.addEventFilter(KeyEvent.ANY, Methods.handlerNumbers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void pane1() {
        pane2.setVisible(false);
        pane3.setVisible(false);
        pane1.setVisible(true);
        buttonPane2.setStyle("-fx-text-fill: #787575;");
        buttonPane1.setStyle("-fx-text-fill: #ffffff;");
    }

    @FXML
    private void pane2() {
        pane1.setVisible(false);
        pane3.setVisible(false);
        pane2.setVisible(true);
        buttonPane1.setStyle("-fx-text-fill: #787575;");
        buttonPane2.setStyle("-fx-text-fill: #ffffff;");
    }

    @FXML
    private void pane3() {
        pane1.setVisible(false);
        pane2.setVisible(false);
        pane3.setVisible(true);
        buttonPane1.setStyle("-fx-text-fill: #787575;");
        buttonPane2.setStyle("-fx-text-fill: #787575;");
        buttonPane3.setStyle("-fx-text-fill: #ffffff;");
    }

    @FXML
    private void busquedaBinaria() throws NumberFormatException {
        vBoxPanel1.getChildren().clear();

        int n = Integer.parseInt(txtTamanio.getText());
        int b = Integer.parseInt(txtBusqueda.getText());

        int[] a = Methods.numerosAleatorios(n);

        HBox hBox = ObjectView.hBox();

        for (int i = 0; i < n; i++) {
            hBox.getChildren().add(ObjectView.text(a[i]));
        }

        addBOX(hBox);

        BusquedaBinaria busquedaBinaria = new BusquedaBinaria();

        busquedaBinaria.localiza(a, b, 0, n - 1);

        addBOX(busquedaBinaria.getVBox());
    }

    @FXML
    public void multiplicacionMatrizSimple() {
        hBoxPanel2.getChildren().clear();

         Matriz matriz;

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

            MultiplicacionMatrizSimple multiplicacionMatrizSimple = new MultiplicacionMatrizSimple();
            multiplicacionMatrizSimple.matrizSimple(matriz, f1, c1, f2,c2,m1,m2,mR);

            addMatrizSimple(multiplicacionMatrizSimple.getVBox());
        } else {
            addMatrizSimple(ObjectView.text("la operación no se puede realizar"));
        }
    }

    @FXML
    private void multiplicacionMatrizDivide_Venceras() {

    }

    @FXML
    public void addBOX(Object n) {
        vBoxPanel1.getChildren().add((Node) n);
    }

    @FXML
    private void addMatrizSimple(Object ob) {
        hBoxPanel2.getChildren().add((Node) ob);
    }

    @FXML
    private void addMatrizDivide(Object ob) {
        hBoxPanel3.getChildren().add((Node) ob);
    }
}
