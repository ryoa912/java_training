/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch02.ex12;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class MyCounter {
	private static final int MAX_STREAM_SIZE = 100;
	public static int[] countShortWords(Stream<String> words, int threshold) {
		AtomicInteger[] shortWords = new AtomicInteger[MAX_STREAM_SIZE];
		for (int i = 0; i < 100; i++) {
			shortWords[i] = new AtomicInteger();
		}
		words.parallel().filter(w -> w.length() < threshold).forEach(w -> shortWords[w.length()].getAndIncrement());
		return Arrays.asList(shortWords).stream().mapToInt(i -> i.get()).toArray();
	}
	public static void main(String[] args) {
		List<String> list = Arrays.asList("a", "bb", "ccc", "dddd", "eeeee");
		Stream<String> stream = list.stream();
		int[] result = MyCounter.countShortWords(stream, 3);
		for (int i=0; i<list.size(); i++) {
			System.out.println(i + ":" + result[i]);
		}
	}
}
