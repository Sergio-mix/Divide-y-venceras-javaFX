package co.edu.unbosque.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Matriz {
	private	int[][] m1; //Matriz A
	private int[][] m2; //Matriz B
	private int[][] mR; //Matriz A * B
}
