/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch02.ex09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class ArrayListUtil<T> {
	private final Stream<ArrayList<T>> source;

	public ArrayListUtil(Stream<ArrayList<T>> source) {
		Objects.requireNonNull(source);
		this.source = source;
	}
	public ArrayList<T> toArrayList() {
		return source.reduce((x, y) -> {
			ArrayList<T> result = new ArrayList<>(x.size() + y.size());
			result.addAll(x);
			result.addAll(y);
			return result;
		}).orElse(new ArrayList<>());
	}
	public static void main(String[] args) {
		List<ArrayList<String>> source = new ArrayList<>();
		source.add(createArrayList("a-1", "a-2", "a-3"));
		source.add(createArrayList("b-1", "b-2", "b-3"));
		source.add(createArrayList("c-1", "c-2", "c-3"));

		ArrayList<String> list = new ArrayListUtil<>(source.stream()).toArrayList();

		for (String str: list) {
			System.out.println(str);
		}

	}
	private static <E> ArrayList<E> createArrayList(E... elements) {
		ArrayList<E> list = new ArrayList<>();
		Collections.addAll(list, elements);
		return list;
}
}
