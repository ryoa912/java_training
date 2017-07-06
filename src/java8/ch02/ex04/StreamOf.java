/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch02.ex04;

import java.util.stream.Stream;

public class StreamOf {
	public static void main(String[] args) {
		int[] values = {1, 4, 9, 16};

		Stream<int[]> stream = Stream.of(values);
		System.out.println(stream);
		stream.forEach(System.out::println);
	}
}
