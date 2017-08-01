/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch03.ex16;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class MyHandler {
	public static <T> void doInOrderAsync(Supplier<T> first, Consumer<T> second,
			Consumer<Throwable> handler) {
		Thread t = new Thread() {
			public void run() {
				try {
					T result = first.get();
					second.accept(result);
				} catch (Throwable t) {
					handler.accept(t);
				}
			}
		};
		t.start();
	}
}
