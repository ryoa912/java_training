/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch03.ex07;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorMaker {
	public static Comparator<String> generate(boolean ascend, boolean ceses) {
		return (str1, str2) -> {
			int result = ceses ? str1.compareTo(str2) : str1.compareToIgnoreCase(str2);
			return ascend ? result : -result;
		};
	}

	public static void main(String[] args) {
		String[] data = {"c", "a", "b"};
		Arrays.sort(data, ComparatorMaker.generate(true, false));
		for (String str: data)
		      System.out.println(str);
	}
}
