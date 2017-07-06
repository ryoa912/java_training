/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch02.ex06;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CharacterStream {
	public static Stream<Character> characterStream(String s) {
		return IntStream.range(0, s.length()).map(s::charAt).mapToObj(i -> (char) i);
	}

	public static void main(String[] args) {
		String value = "test";
		Stream<Character> steam = CharacterStream.characterStream(value);
		steam.forEach(System.out::println);
	}
}
