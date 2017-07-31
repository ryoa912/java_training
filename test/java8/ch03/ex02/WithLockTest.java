/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch03.ex02;

import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class WithLockTest {
	@Test
	public void testWithLock() {
		ReentrantLock lock = new ReentrantLock();
		WithLock.withLock(lock, () -> System.out.println("test"));
	}

}
