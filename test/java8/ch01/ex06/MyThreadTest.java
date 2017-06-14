/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch01.ex06;

import org.junit.Test;

public class MyThreadTest {

	@Test
	public void testUnCheck_1() {
        MyThread.uncheck(
        		() -> { System.out.println("Zzz"); Thread.sleep(1000);} ).run();
	}

	@Test
	public void testUnCheck_2() {
        MyThread.uncheck(
        		() -> { /* Nothing */ }).run();
	}
}
