/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch03.ex24;

import java.util.AbstractMap;
import java.util.function.Function;

public class Pair<T> extends AbstractMap.SimpleEntry<T, T> {
	public Pair(T key, T value) {
		super(key, value);
	}

	public <U> Pair<U> map(Function<? super T, ? extends U> mapper) {
		return new Pair<>(mapper.apply(getKey()), mapper.apply(getValue()));
	}

	public <U> Pair<U> flatMap(Function<? super T, Pair<U>> mapper) {
		T target = getKey();
		return mapper.apply(target);
	}

	public static void main(String[] args) {
		Pair<String> src = new Pair<>("hoge", "fuga");
		Pair<Integer> dst = src.map(String::length);
		System.out.println("key_length = " + dst.getKey() + ", value_length = " + dst.getValue());
	}
}
