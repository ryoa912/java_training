/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch03.ex20;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListUtil {
	public static <T, U> List<U> map(List<T> list, Function<T, U> mapper) {
		return list.stream().map(mapper::apply).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		List<String> src = Arrays.asList("a", "bb", "ccc");
		List<Integer> dst = ListUtil.map(src, String::length);
		for (int i=0; i<dst.size(); i++)
			System.out.println(dst.get(i).toString());
	}
}
