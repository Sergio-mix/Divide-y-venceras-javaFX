package co.edu.unbosque.controller;

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
}
