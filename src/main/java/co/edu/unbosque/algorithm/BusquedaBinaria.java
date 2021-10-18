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
    public Integer localiza(int[] a, int busqueda, int izquierda, int derecha) {
        try {
            int i;

            if (busqueda == a[izquierda]) {
                add(ObjectView.text(busqueda + " = " + a[izquierda]));
                add(ObjectView.text("Elemento en la posición: " + izquierda));
                return izquierda;
            }

            if (busqueda == a[derecha]) {
                add(ObjectView.text(busqueda + " = " + a[derecha]));
                add(ObjectView.text("Elemento en la posición: " + derecha));
                return derecha;
            }

            if (izquierda > derecha) {
                add(ObjectView.text("No se encontro el elemento: " + busqueda));
                return null;
            }

            i = (izquierda + derecha + 1) / 2;

            if (busqueda == a[i]) {
                add(ObjectView.text(busqueda + " = " + a[i]));

                add(ObjectView.hBox(ObjectView.hBox(a[i])));

                add(ObjectView.text("Elemento en la posición: " + i));

                return i;
            } else if (busqueda < a[i]) {
                add(ObjectView.text(busqueda + " < " + a[i]));

                HBox hBox = ObjectView.hBox();

                for (int n = 1; n < i; n++) {
                    hBox.getChildren().add(ObjectView.text(a[n]));
                }

                add(ObjectView.hBox(hBox));

                return localiza(a, busqueda, 1, i - 1);

            } else if (busqueda > a[i]) {
                add(ObjectView.text(busqueda + " > " + a[i]));

                HBox hBox = ObjectView.hBox();

                for (int n = i; n < derecha; n++) {
                    hBox.getChildren().add(ObjectView.text(a[n]));
                }

                add(ObjectView.hBox(hBox));

                return localiza(a, busqueda, i + 1, derecha);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @FXML
    private void add(Node n) {
        vBox.getChildren().add( n);
    }
}
