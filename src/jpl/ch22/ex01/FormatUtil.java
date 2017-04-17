/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch22.ex01;

public class FormatUtil {
	private static final int MAX_INT_DIGIT = 40;		//整数部の最大桁数
	private static final int MAX_PRE_DIGIT = 40;		//小数部の最大桁数

	public static final void printDoubleArray(double[] array) {
		int max_int_digit = 0;
		for (int i=0; i<array.length; i++) {
			String d_str = String.valueOf(array[i]);
			String[] i_array = d_str.split("\\.", -1);
			System.out.printf(String.format("%40s", i_array[0]));
			System.out.printf(".");
			System.out.printf(String.format("%-40s%n", i_array[1]));
		}
	}

	public static void main(String[] args) {
		double[] d_array = {
				1.111111111111111111111111,
				1.222222222222,
				1111.333333333
		};
	}
}
