/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch02.ex08;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Zip {
	public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(new DualIterator<>(first.iterator(), second.iterator()),
				Spliterator.ORDERED | Spliterator.IMMUTABLE | Spliterator.NONNULL), false);
	}

	private static class DualIterator<T> implements Iterator<T> {
	    private final Iterator<T> first;
	    private final Iterator<T> second;
	    private boolean fetch_first = true;

		public DualIterator(Iterator<T> first, Iterator<T> second) {
            this.first = first;
            this.second = second;
}
		@Override
		public boolean hasNext() {
			return first.hasNext() || second.hasNext();
		}
		@Override
		public T next() {
			T result = fetch_first ?
					(first.hasNext() ? first.next() : second.next()) :
						(second.hasNext() ? second.next() : first.next());
			fetch_first = !fetch_first;
			return result;
		}
	}
}
