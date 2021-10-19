package co.edu.unbosque.controller;

import java.net.URL;
import java.util.*;

import co.edu.unbosque.algorithm.BusquedaBinaria;
import co.edu.unbosque.algorithm.MultiplicacionMatrizDivide_Venceras;
import co.edu.unbosque.model.Matriz;
import co.edu.unbosque.components.ObjectView;
import co.edu.unbosque.algorithm.MultiplicacionMatrizSimple;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
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
    private VBox vBoxPanel3;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            //Color botones del panel superior
            buttonPane2.setStyle("-fx-text-fill: #787575;");
            buttonPane1.setStyle("-fx-text-fill: #ffffff;");
            buttonPane3.setStyle("-fx-text-fill: #787575;");

            //Validar solo numeros
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

    /**
     * Panel 1 visible
     */
    @FXML
    private void pane1() {
        pane2.setVisible(false);
        pane3.setVisible(false);
        pane1.setVisible(true);
        buttonPane2.setStyle("-fx-text-fill: #787575;");
        buttonPane1.setStyle("-fx-text-fill: #ffffff;");
        buttonPane3.setStyle("-fx-text-fill: #787575;");
    }

    /**
     * Panel 2 visible
     */
    @FXML
    private void pane2() {
        pane1.setVisible(false);
        pane3.setVisible(false);
        pane2.setVisible(true);
        buttonPane1.setStyle("-fx-text-fill: #787575;");
        buttonPane2.setStyle("-fx-text-fill: #ffffff;");
        buttonPane3.setStyle("-fx-text-fill: #787575;");
    }

    /**
     * Panel 3 visible
     */
    @FXML
    private void pane3() {
        pane1.setVisible(false);
        pane2.setVisible(false);
        pane3.setVisible(true);
        buttonPane1.setStyle("-fx-text-fill: #787575;");
        buttonPane2.setStyle("-fx-text-fill: #787575;");
        buttonPane3.setStyle("-fx-text-fill: #ffffff;");
    }

    /**
     * Método para iniciar algoritmo de busqueda binaria
     *
     * @throws NumberFormatException
     */
    @FXML
    private void busquedaBinaria() throws NumberFormatException {
        vBoxPanel1.getChildren().clear();//Borrar elementos panel 1

        //Tamanio del array
        int n = Integer.parseInt(txtTamanio.getText());

        //Numero a buscqr
        int b = Integer.parseInt(txtBusqueda.getText());

        //Array con numeros aleatorios oredenados
        int[] a = Methods.numerosAleatorios(n);

        HBox hBox = ObjectView.hBox();//Contenedor

        //Agregar array al contenedor
        for (int i = 0; i < n; i++)
            hBox.getChildren().add(ObjectView.text(a[i]));

        addBOX(hBox);//Agregar contenedor al panel 1

        BusquedaBinaria busquedaBinaria = new BusquedaBinaria();

        Integer result = busquedaBinaria.localiza(a, b, 0, n - 1);//Algoritmo

        addBOX(busquedaBinaria.getVBox());//Agregar parte visual del algoritmo al panel 3

        if (result != null) {
            addBOX(ObjectView.text("Elemento en la posición: " + result));
        } else {
            addBOX(ObjectView.text("No se encontro el elemento: " + b));
        }
    }

    //Método para iniciar Multiplicacion silple de matriz
    @FXML
    public void multiplicacionMatrizSimple() throws NumberFormatException {
        hBoxPanel2.getChildren().clear();//Borrar elementos panel 2

        Matriz matriz;

        int f1 = Integer.parseInt(txtFilaMatris1.getText());//fila 1
        int c1 = Integer.parseInt(txtColumnaMatriz1.getText());//Columna 1
        int f2 = Integer.parseInt(txtFilaMatris2.getText());//fila 2
        int c2 = Integer.parseInt(txtColumnaMatriz2.getText());//columna 2

        if (c1 == f2) {
            int[][] m1 = new int[f1][c1];
            int[][] m2 = new int[f2][c2];
            int[][] mR = new int[f1][c2];

            matriz = new Matriz(m1, m2, mR);

            //Agregar elementos a la matriz 1
            for (int i = 0; i < f1; i++) {
                for (int j = 0; j < c1; j++) {
                    m1[i][j] = Methods.numeroAleatorio();//Numero aleatorio
                    matriz.setM1(m1);
                }
            }

            //Agregar elementos a la matriz 2
            for (int i = 0; i < f2; i++) {
                for (int j = 0; j < c2; j++) {
                    m2[i][j] = Methods.numeroAleatorio();//Numero aleatorio
                    matriz.setM2(m2);
                }
            }

            MultiplicacionMatrizSimple multiplicacionMatrizSimple = new MultiplicacionMatrizSimple();
            multiplicacionMatrizSimple.matrizSimple(matriz, f1, c1, f2, c2, m1, m2, mR);//Algoritmo

            addMatrizSimple(multiplicacionMatrizSimple.getVBox());//Agregar parte visual al panel 2
        } else {
            addMatrizSimple(ObjectView.text("la operación no se puede realizar"));
        }
    }

    /**
     * Método para iniciar algoritmo de matriz por divide y venceras
     */
    @FXML
    private void multiplicacionMatrizDivide_Venceras() throws NumberFormatException {
        vBoxPanel3.getChildren().clear();//Borrar elementos panel 3

        int f = Integer.parseInt(txtFilaMatris3.getText());//Numero dde filas
        int c = Integer.parseInt(txtColumnaMatriz3.getText());//Numero de columnas
        if (f == c && f % 2 == 0) {
            HBox hBox = ObjectView.hBox_v2();//Contenedor

            GridPane gridPane1 = ObjectView.gridPane();//Sub contenedor
            int[][] A = new int[f][c];
            //llenar matriz 1
            for (int i = 0; i < f; i++) {
                for (int j = 0; j < c; j++) {
                    A[i][j] = Methods.numeroAleatorio();//Numero aleatorio
                    gridPane1.add(ObjectView.text(A[i][j]), j, i);
                }
            }

            hBox.getChildren().add(gridPane1);//agregar sub contenedor al contenedor principal
            hBox.getChildren().add(ObjectView.text("#FC4C00FF", "X", "50px"));

            GridPane gridPane2 = ObjectView.gridPane();//Sub contenedor
            int[][] B = new int[f][c];
            //llenar matriz 2
            for (int i = 0; i < f; i++) {
                for (int j = 0; j < c; j++) {
                    B[i][j] = Methods.numeroAleatorio();//Numero aleatorio
                    gridPane2.add(ObjectView.text(B[i][j]), j, i);
                }
            }

            hBox.getChildren().add(gridPane2);//agregar sub contenedor al contenedor principal
            hBox.getChildren().add(ObjectView.text("#1FCD7FFF", "=", "60px"));

            MultiplicacionMatrizDivide_Venceras
                    multiplicacionMatrizDivide_venceras
                    = new MultiplicacionMatrizDivide_Venceras();

            int[][] C = multiplicacionMatrizDivide_venceras.multiply(A, B);//Algoritmo

            GridPane gridPane3 = ObjectView.gridPane();//Sub contenedor
            //Matriz respuesta
            for (int i = 0; i < f; i++) {
                for (int j = 0; j < c; j++)
                    gridPane3.add(ObjectView.text(C[i][j]), j, i);
            }

            hBox.getChildren().add(gridPane3);//agregar sub contenedor al contenedor principal
            addMatrizDivide(hBox);//agregar al contenedor
        } else {
            addMatrizDivide(ObjectView.text("la operación no se puede realizar"));
        }
    }

    /**
     * Método para agregar contenido al panel 1
     *
     * @param n Objeto agregado al panel
     */
    @FXML
    public void addBOX(Object n) {
        vBoxPanel1.getChildren().add((Node) n);
    }

    /**
     * Método para agregar contenido al panel 1
     *
     * @param ob Objeto agregado al panel
     */
    @FXML
    private void addMatrizSimple(Object ob) {
        hBoxPanel2.getChildren().add((Node) ob);
    }

    /**
     * Método para agregar contenido al panel 1
     *
     * @param ob Objeto agregado al panel
     */
    @FXML
    private void addMatrizDivide(Object ob) {
        vBoxPanel3.getChildren().add((Node) ob);
    }
}
