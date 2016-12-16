package jpl.ch07.ex03;

public class PascalTriangles {
	public static int[][] value;

	static int[][] createPascalTriangles(int nest) {
		value = new int[nest][];

		//init
		value[0] = new int[1];
		value[0][0] = 1;

		for (int i=1; i<nest; i++) {
			value[i] = new int[i+1];
			for (int j=0; j<=i; j++) {
				if (j==0) {
					value[i][j] = value[i-1][j];
				} else if (j==i) {
					value[i][j] = value[i-1][j-1];
				} else {
					value[i][j] = value[i-1][j] + value[i-1][j-1];
				}
			}
		}
		return value;
	}
	public static void main(String[] args) {
		PascalTriangles.createPascalTriangles(12);
	}
}
