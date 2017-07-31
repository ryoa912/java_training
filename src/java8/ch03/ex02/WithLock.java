/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch03.ex02;

import java.util.concurrent.locks.ReentrantLock;

public class WithLock {
	public static void withLock(ReentrantLock lock, Runnable runnable) {
		if (lock.isLocked()) {
			throw new IllegalStateException("Lock is already held.");
		}
		lock.lock();
		try {
			runnable.run();
		} finally {
			lock.unlock();
		}
}
}
