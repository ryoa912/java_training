package jpl.ch07.ex03;

import java.util.Arrays;

import org.junit.Test;

public class PascalTrianglesTest {

	@Test
	public void testCreatePascalTriangles() {
		int nest = 12;

		int[][] ret = PascalTriangles.createPascalTriangles(nest);

		print2DimArray(ret);
	}

	@Test
	public void testCreatePascalTriangles_100() {
		int nest = 100;

		int[][] ret = PascalTriangles.createPascalTriangles(nest);

		print2DimArray(ret);
	}

	private void print2DimArray(int[][] array) {
		for (int i=0; i<array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}
	}

}
