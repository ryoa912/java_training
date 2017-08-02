/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch04.ex05;

import java.util.function.BiFunction;
import java.util.function.Function;

import javafx.beans.value.ObservableValue;

public class MyObserver {
	public static <T, R> ObservableValue<R> observe(Function<T, R> f, ObservableValue<T> t) {
		return null;
	}

	public static <T, U, R> ObservableValue<R> observe(
			BiFunction<T, U, R> f, ObservableValue<T> t, ObservableValue<U> u) {
		return null;
	}
}
