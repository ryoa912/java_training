/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch02.ex02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FilterSample {
	private int cursor = 0;

	public void logging(boolean result) {
		System.out.print(result ? "high," : "low,");
		cursor++;
		if (cursor >= 80) {
			System.out.println();
			cursor = 0;
		}
	}

	public static void main(String[] args) throws IOException {
		FilterSample filter = new FilterSample();
		String contents = new String(Files.readAllBytes(Paths.get("src/java8/ch02/ex02/alice.txt")), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
		System.out.println("Number of words: " + words.size());
		long count = words.stream().filter(w -> {
			boolean result = w.length() > 2;
			filter.logging(result);
			return result;
		}).limit(5).count();
		System.out.println();
		System.out.println("count: " + count);
	}
}
