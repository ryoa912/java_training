/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch22.ex05;

public class Dice {
	public static final int DICE_SURFACE = 6;
	public static final void printExpectedValue(int dice_num) {
		int min = dice_num;
		int max = DICE_SURFACE * dice_num;

		for (int i=min; i<max; i++) {
			System.out.println(i + ": " + score(dice_num, i));
		}
	}
	public static final int MAX = 26;

	public static int score(int dice_num, int sum) {
	    int i, j, k;
	    int s;
	    int[][] tbl = new int[MAX+1][6*MAX+1];

	    if (sum < dice_num || sum > 6*dice_num) return 0;
	    if (dice_num > MAX) return -1;
	    for (i = 1; i <= 6; i++) tbl[1][i] = 1;
	    for (i = 2; i <= dice_num; i++) {
	        for (j = i; j <= 6*i; j++) {
	            for (k = 1, s = 0; k <= 6; k++) {
	                if (j >= k) s += tbl[i-1][j-k];
	            }
	            tbl[i][j] = s;
	        }
	    }
	    return tbl[dice_num][sum];
	}

	public static final void main(String[] args) {
		printExpectedValue(10);
	}
}
