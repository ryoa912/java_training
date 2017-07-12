/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch02.ex10;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class MyCalculator {
	public static double sum(Stream<Double> stream) {
		Optional<Double> sum = stream.reduce((x, y) -> x + y);
		return sum.get();
	}
	public static void main(String[] args) {
		List<Double> list = Arrays.asList(1.0, 2.0, 3.0);
		Stream<Double> stream = list.stream();
		Double result = MyCalculator.sum(stream);
		System.out.println("Average: " + result /list.size());
	}
}
