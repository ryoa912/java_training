/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch02.ex07;

import java.util.stream.Stream;

public class MyMath {
	public static <T> boolean isFinite(Stream<T> stream) {
		long result = stream.spliterator().getExactSizeIfKnown();
		return  result != -1 ? true : false;
	}
}
