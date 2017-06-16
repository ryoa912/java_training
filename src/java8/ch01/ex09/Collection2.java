/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch01.ex09;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public interface Collection2<T> extends Collection<T> {

	default void forEachIf(Consumer<T> action, Predicate<T> filter) {
		Stream<T> stream = this.stream();
		stream.filter(filter).forEach(action);
	}
}
