/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch02.ex08;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

public class ZipTest {

	@Test
	public void testZip_1() {
		List<String> lista = Arrays.asList("a");
		List<String> listb = Arrays.asList("a", "b");
		Stream<String> first = lista.stream();
		Stream<String> second = listb.stream();
		Stream<String> result = Zip.zip(first, second);
		String[] dumped = result.toArray(String[]::new);
		for (String s: dumped) {
			System.out.println(s);
		}
	}

	@Test
	public void testZip_2() {
		List<String> lista = Arrays.asList("a", "b");
		List<String> listb = Arrays.asList("a", "b", "c");
		Stream<String> first = lista.stream();
		Stream<String> second = listb.stream();
		Stream<String> result = Zip.zip(first, second);
		String[] dumped = result.toArray(String[]::new);
		for (String s: dumped) {
			System.out.println(s);
		}
	}

	@Test
	public void testZip_3() {
		List<String> lista = Arrays.asList("a");
		List<String> listb = Arrays.asList("a", "b", "c");
		Stream<String> first = lista.stream();
		Stream<String> second = listb.stream();
		Stream<String> result = Zip.zip(first, second);
		String[] dumped = result.toArray(String[]::new);
		for (String s: dumped) {
			System.out.println(s);
		}
	}
}
