package co.edu.unbosque.controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Collections;
import java.util.Stack;

public class Methods {
    public Methods() {

    }

    public static int[] numerosAleatorios(int size) {
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

    public static int numeroAleatorio() {
        return (int) Math.floor(Math.random() * 50);
    }

    public static EventHandler<KeyEvent> handlerNumbers = new EventHandler<KeyEvent>() {
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
