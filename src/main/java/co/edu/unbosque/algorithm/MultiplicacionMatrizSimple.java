package co.edu.unbosque.algorithm;

import co.edu.unbosque.components.ObjectView;
import co.edu.unbosque.model.Matriz;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class MultiplicacionMatrizSimple {

    @FXML
    private HBox hBox;

    @FXML
    @Getter
    private VBox vBox;

    @FXML
    private GridPane gridPane;

    public MultiplicacionMatrizSimple() {
        hBox = ObjectView.hBox_v2();
        vBox = ObjectView.vBox(50);
        gridPane = ObjectView.gridPane_v2();
    }

    @FXML
    public void matrizSimple(Matriz matriz, int f1, int c1, int f2, int c2, int[][] m1, int[][] m2, int[][] mR) throws NumberFormatException {
        List<String> listText = new ArrayList<>();

        GridPane gridPane1 = ObjectView.gridPane();
        for (int i = 0; i < f1; i++) {
            for (int j = 0; j < c1; j++) {
                gridPane1.add(ObjectView.text(matriz.getM1()[i][j]), j, i);
            }
        }

        addHBox(gridPane1);
        addHBox(ObjectView.text("#FC4C00FF", "X", "50px"));

        GridPane gridPane2 = ObjectView.gridPane();
        for (int i = 0; i < f2; i++) {
            for (int j = 0; j < c2; j++) {
                gridPane2.add(ObjectView.text(matriz.getM2()[i][j]), j, i);
            }
        }

        addHBox(gridPane2);
        addHBox(ObjectView.text("#1FCD7FFF", "=", "60px"));

        GridPane gridPane3 = ObjectView.gridPane();

        for (int i = 0; i < f1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int h = 0; h < c1; h++) {
                    mR[i][j] += m1[i][h] * m2[h][j];

                    listText.add(
                            m1[i][h] + " * " + m2[h][j]);
                }

                matriz.setMR(mR);
                gridPane3.add(ObjectView.text(matriz.getMR()[i][j]), j, i);
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < f1; i++) {
            for (int j = 0; j < c2; j++) {
                result.add(String.valueOf(matriz.getMR()[i][j]));
            }
        }

        List<String> list = new ArrayList<>();
        int e = 0;
        while (e < result.size() * 2) {
            list.add(listText.get(e) + " + " + listText.get(e + 1));
            e += 2;
        }

        for (int i = 0; i < list.size(); i++) {
            String ie = list.get(i) + " = " + result.get(i);
            list.set(i, ie);
        }


        int i = 0;
        int j = 0;
        int r = Math.max(f1, f2);
        for (String t : list) {
            addGrid(ObjectView.text("#000000",
                    t,
                    "18"), i, j);
            j++;

            if (j == r + 1) {
                i += 1;
                j = 0;
            }
        }

        addHBox(gridPane3);
        addVBox(hBox);
        addVBox(gridPane);
    }

    @FXML
    private void addHBox(Node n) {
        hBox.getChildren().add(n);
    }

    @FXML
    private void addVBox(Node n) {
        vBox.getChildren().add(n);
    }

    private void addGrid(Node n, int i, int j) {
        gridPane.add(n, i, j);
    }
}
