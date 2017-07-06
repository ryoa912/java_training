/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch02.ex05;

import java.util.stream.Stream;

public class IteratedStream {
	public static void main(String[] args) {
		Stream<Long> stream = Stream.iterate(1L, n -> random(25214903917L, 11, (long) Math.pow(2, 48), n));
		stream.limit(100).forEach(System.out::println);
	}

	private static long random(long a, long c, long m, long x) {
		return (a * x + c) % m;
	}
}
