package co.edu.unbosque.algorithm;

import co.edu.unbosque.components.ObjectView;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lombok.Getter;

public class BusquedaBinaria {

    @FXML
    @Getter
    private VBox vBox;

    public BusquedaBinaria() {
        vBox = ObjectView.vBox();
    }

    @FXML
    public Integer localiza(int[] a, int busqueda, int izquierda, int derecha) throws NumberFormatException {
        try {
            int i;

            if (izquierda > derecha) {
                return null;
            }

            i = (izquierda + derecha + 1) / 2;

            if (busqueda == a[i]) {
                add(ObjectView.text(busqueda + " = " + a[i]));

                HBox result = ObjectView.hBox();
                result.getChildren().add(ObjectView.text(a[i]));
                add(ObjectView.hBox(result));

                return i;
            } else if (busqueda < a[i]) {
                derecha = i - 1;
                add(ObjectView.text(busqueda + " < " + a[i]));

                HBox hBox = ObjectView.hBox();

                for (int n = izquierda; n <= derecha; n++)
                    hBox.getChildren().add(ObjectView.text(a[n]));

                add(ObjectView.hBox(hBox));

                return localiza(a, busqueda, izquierda, derecha);

            } else if (busqueda > a[i]) {
                izquierda = i + 1;
                add(ObjectView.text(busqueda + " > " + a[i]));

                HBox hBox = ObjectView.hBox();

                for (int n = izquierda; n <= derecha; n++)
                    hBox.getChildren().add(ObjectView.text(a[n]));

                add(ObjectView.hBox(hBox));

                return localiza(a, busqueda, izquierda, derecha);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @FXML
    private void add(Node n) {
        vBox.getChildren().add(n);
    }
}
