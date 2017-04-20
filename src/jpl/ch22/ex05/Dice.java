/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch22.ex05;

import java.util.Random;

public class Dice {
	public static final int DICE_SURFACE = 6;
	public static final int MAX = 26;
	private static final double TRIAL_NUM = 50000;
	private static Random r = new Random();
	/**
	 * サイコロの複数個振ったときの合計値の分布を出力する
	 * @param dice_num サイコロの個数
	 */
	public static final void printExpectedValue(int dice_num) {
		double total_case_num = cases(dice_num);
		System.out.println("[Expected value]");
		System.out.println("[Total cases]: " + total_case_num + " cases.");
		double answer;
		for (int i=dice_num; i<DICE_SURFACE * dice_num; i++) {
			int score = score(dice_num, i);
			System.out.println("[" + i + "]: " + score + " cases.");
			answer = score / total_case_num;
			System.out.println("Rate: " + answer + " %");
		}
	}

	/**
	 * サイコロを複数個振って出る合計値の場合の数を求める
	 * @param dice_num サイコロの個数
	 * @param sum 合計値
	 * @return 場合の数
	 * @exception サイコロの個数の最大値を超えた場合に例外をスロー、合計値がサイコロの個数以下なら例外をスロー
	 */
	public static int score(int dice_num, int sum) throws IllegalArgumentException {
	    if (sum < dice_num || sum > 6*dice_num)
	    	throw new IllegalArgumentException();
	    if (dice_num > MAX)
	    	throw new IllegalArgumentException();
	    int[][] tbl = new int[MAX+1][6*MAX+1];

	    for (int i = 1; i <= 6; i++)
	    	tbl[1][i] = 1;
	    for (int i = 2; i <= dice_num; i++) {
	        for (int j = i; j <= 6*i; j++) {
	        	int s = 0;
	            for (int k = 1; k <= 6; k++) {
	                if (j >= k) s += tbl[i-1][j-k];
	            }
	            tbl[i][j] = s;
	        }
	    }
	    return tbl[dice_num][sum];
	}

	/**
	 * 全ての出目の通りを求める。サイコロの面数の個数乗。
	 * @param dice_num サイコロの個数
	 * @return 全ての出目の通り数
	 */
	public static double cases(int dice_num) {
		return Math.pow(DICE_SURFACE, dice_num);
	}

	/**
	 * 実際にサイコロの出目を乱数で出し、出目の合計の分布を出力する。
	 * @param dice_num サイコロの個数
	 */
	public static void printRealValue(int dice_num) {
		System.out.println("[Real value]");
		System.out.println("[Trial]: " + TRIAL_NUM + " times.");
		int min = dice_num;
		int max = dice_num * DICE_SURFACE;
		int[] result = new int[max - min +1];
		for (int i=0; i<result.length; i++) result[i] = 0;

		for (int i=0; i<TRIAL_NUM; i++) {
			result[getDiceValue(dice_num)]++;
		}

		double answer;
		for (int i=0; i<result.length; i++) {
			System.out.println("[" + (i+min) + "]: " + result[i]);
			answer = result[i] / TRIAL_NUM;
			System.out.println("Rate: " + answer + " %");
		}
	}

	/**
	 * サイコロの出目の合計値をランダムに出力する（出目は0～面数-1）
	 * @param dice_num サイコロの個数
	 * @return サイコロの出目の合計値
	 */
	public static int getDiceValue(int dice_num) {
		int result = 0;
		for (int i=0; i<dice_num; i++) {
			result += r.nextInt(DICE_SURFACE);
		}
		return result;
	}

	public static final void main(String[] args) {
		printExpectedValue(10);
		printRealValue(10);
	}
}
