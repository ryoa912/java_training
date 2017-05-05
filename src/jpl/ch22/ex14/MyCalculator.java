/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch22.ex14;

import java.util.StringTokenizer;

public class MyCalculator {
	/**
	 * 複数の浮動小数点数字を含む文字列を受け取り、区切り文字として空白を使用して分解し、合計を返す。
	 * @param str 複数の浮動小数点を含む文字列（区切り文字空白）
	 * @return 合計
	 */
	public static double sum(String str) {
        StringTokenizer tokenizer = new StringTokenizer(str, " ");
        double total = 0;
        while (tokenizer.hasMoreTokens())
            total += Double.valueOf(tokenizer.nextToken());
        return total;
	}

	public static void main(String[] args) {
        System.out.println(MyCalculator.sum("1 0.1 0.01 0.001 0.0001"));
	}
}
