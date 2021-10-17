package co.edu.unbosque.model;

public class Matriz {
	private	int[][] m1; 
	private int[][] m2;
	private int[][] mR;
	
	public Matriz(int[][] m1, int[][] m2, int[][] mR) {
		this.m1 = m1;
		this.m2 = m2;
		this.mR = mR;
	}

	public int[][] getM1() {
		return m1;
	}

	public void setM1(int[][] m1) {
		this.m1 = m1;
	}

	public int[][] getM2() {
		return m2;
	}

	public void setM2(int[][] m2) {
		this.m2 = m2;
	}

	public int[][] getmR() {
		return mR;
	}

	public void setmR(int[][] mR) {
		this.mR = mR;
	}
	
	

}
