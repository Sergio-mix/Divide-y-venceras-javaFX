package co.edu.unbosque.controller;

import java.net.URL;
import java.util.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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
    private TextField txtBusqueda;

    @FXML
    private TextField txtTamanio;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonPane2.setStyle("-fx-text-fill: #787575;");
        buttonPane1.setStyle("-fx-text-fill: #ffffff;");
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
        vBoxPanel1.setAlignment(Pos.TOP_CENTER);

        int n = Integer.parseInt(String.valueOf(txtTamanio.getText()));
        int b = Integer.parseInt(String.valueOf(txtBusqueda.getText()));

        int[] a = numerosAleatorios(n);

        HBox hBox = hBox();

        for (int i = 0; i < n; i++) {
            Text text = text();
            text.setText(String.valueOf(a[i]));
            hBox.getChildren().add(text);
        }
        vBoxPanel1.getChildren().add(hBox);

        localiza(a, b, 0, n-1);
    }

    public Integer localiza(int[] a, int busqueda, int izquierda, int derecha) {
        int i;

        if (busqueda == a[0]) {
            Text t = text();
            t.setText("Elemento en la posición: " + 0);
            vBoxPanel1.getChildren().add(t);
            return null;
        }

        if (busqueda == a[derecha]) {
            Text t = text();
            t.setText("Elemento en la posición: " + derecha);
            vBoxPanel1.getChildren().add(t);
            return null;
        }

        if (izquierda > derecha) {
            Text t = text();
            t.setText("No se encontro el elemento: " + busqueda);
            vBoxPanel1.getChildren().add(t);

            return null;
        }

        i = (izquierda + derecha + 1) / 2;

        if (busqueda == a[i]) {
            Text t = text();
            t.setText(busqueda + " = " + a[i]);
            vBoxPanel1.getChildren().add(t);

            HBox hBox = hBox();
            Text text = text();
            text.setText(String.valueOf(a[i]));
            hBox.getChildren().add(text);
            vBoxPanel1.getChildren().add(hBox);

            Text t2 = text();
            t2.setText("Elemento en la posición: " + i);
            vBoxPanel1.getChildren().add(t2);

            return i;
        } else if (busqueda < a[i]) {
            Text t = text();
            t.setText(busqueda + " < " + a[i]);
            vBoxPanel1.getChildren().add(t);

            HBox hBox = hBox();

            for (int n = izquierda; n < i; n++) {
                Text text = text();
                text.setText(String.valueOf(a[n]));
                hBox.getChildren().add(text);
            }

            vBoxPanel1.getChildren().add(hBox);

            return localiza(a, busqueda, 1, i - 1);

        } else if (busqueda > a[i]) {
            Text t = text();
            t.setText(busqueda + " > " + a[i]);
            vBoxPanel1.getChildren().add(t);

            HBox hBox = hBox();

            for (int n = i; n < derecha; n++) {
                Text text = text();
                text.setText(String.valueOf(a[n]));
                hBox.getChildren().add(text);
            }

            vBoxPanel1.getChildren().add(hBox);

            return localiza(a, busqueda, i + 1, derecha);
        }

        return null;
    }

    private void matris() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Introduzca el numero de filas de la matriz");
        int f1 = leer.nextInt();
        System.out.println("Introduzca el numero de Columnas de la matriz");
        int c1 = leer.nextInt();
        System.out.println("Introduzca el numero de filas de la matriz 2");
        int f2 = leer.nextInt();
        System.out.println("Introduzca el numero de Columnas de la matriz 2");
        int c2 = leer.nextInt();
        System.out.println("---Datos ingresados---");
        System.out.println("---Matriz 1 de: " + f1 + "x" + c1 + "--");
        System.out.println("---Matriz 1 de: " + f2 + "x" + c2 + "--");
        System.out.println("----------------------------------------");
        if (c1 == f2) {
            int[][] m1 = new int[c1][f1];
            int[][] m2 = new int[c2][f2];
            int[][] mR = new int[f1][c2];

            for (int i = 0; i < f1; i++) {
                for (int j = 0; j < c1; j++) {
                    System.out.println("Introduce los valores del elemento " + i + " , " + j + ":");
                    m1[i][j] = leer.nextInt();
                }

            }
            for (int i = 0; i < f1; i++) {
                for (int j = 0; j < c1; j++) {
                    System.out.print(m1[i][j] + " ");

                }
                System.out.println("");

            }
            // Matriz 2
            System.out.println("comienza matriz 2");
            for (int i = 0; i < f2; i++) {
                for (int j = 0; j < c2; j++) {
                    System.out.println("Introduce los valores del elemento " + i + " , " + j + ":");
                    m2[i][j] = leer.nextInt();
                }

            }
            for (int i = 0; i < f2; i++) {
                for (int j = 0; j < c2; j++) {
                    System.out.print(m1[i][j] + " ");

                }
                System.out.println("");

            }
            System.out.println("Matriz resultante");
            // Matriz resultante
            for (int i = 0; i < f1; i++) {
                for (int j = 0; j < c2; j++) {
                    for (int h = 0; h < c1; h++) {
                        mR[i][j] += m1[i][h] * m2[h][j];
                    }
                    System.out.print(mR[i][j] + " ");
                }
                System.out.println("");
            }
        } else {
            System.out.println("la operacion no se puede realizar");
        }
    }

    private HBox hBox() {
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(30);

        hBox.setStyle("-fx-border-radius: 15 15 15 15;" +
                " -fx-background-color: #eeeeee;" +
                " -fx-effect: dropshadow(gaussian, rgb(35,35,35), 5, 0.5, 0.0, 0.0);" +
                "-fx-pref-height:50px;" +
                "-fx-background-radius:15 15 15 15;" +
                "");

        return hBox;
    }

    private Text text() {
        Text text = new Text();
        text.setStyle("-fx-text-fill:#FFFFFF;" +
                " -fx-font-size: 26px;" +
                "-fx-font-family: Arial;");

        return text;
    }

    private int[] numerosAleatorios(int size) {
        int pos;

        Stack<Integer> p = new Stack<Integer>();
        for (int i = 0; i < size; i++) {
            pos = (int) Math.floor(Math.random() * (size * 2));
            while (p.contains(pos)) {
                pos = (int) Math.floor(Math.random() * (size * 2));
            }
            p.push(pos);
        }

        Collections.sort(p);

        int[] a = new int[size];

        for (int i = 0; i < size; i++) {
            a[i] = p.get(i);
        }

        return a;
    }

}
