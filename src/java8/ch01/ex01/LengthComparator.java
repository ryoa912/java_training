/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch01.ex01;

import java.util.Arrays;
import java.util.Comparator;

//Arrays.sort メソッド内で呼び出されるコンパレータのコードは、sortメソッドを呼び出したスレッドで実行されるか。
//それとも、別のスレッドで実行されるか。
//⇒呼び出したスレッドで実行される。(実行中のスレッド名を出力すると全て同じ。)

public class LengthComparator implements Comparator<String>{
	@Override
	public int compare(String first, String second) {
		System.out.println(Thread.currentThread().getName());
		return Integer.compare(first.length(), second.length());
	}

	public static void main(String[] args) {
		String[] strings = {"aaaaa", "aaaa", "aaa", "aa", "a"};

		System.out.println(Thread.currentThread().getName());
		Arrays.sort(strings, new LengthComparator());

		for (String str: strings) {
			System.out.println(str);
		}

		System.out.println(Thread.currentThread().getName());
	}
}