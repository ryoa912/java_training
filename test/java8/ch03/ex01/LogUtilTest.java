/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch03.ex01;

import java.util.logging.Level;

import org.junit.Test;

public class LogUtilTest {
	@Test
	public void testLogIf_1() {
		LogUtil logger = new LogUtil("test", null);
		logger.setLevel(Level.ALL);
		logger.logIf(Level.FINEST, () -> true, () -> "OK");
	}
	@Test
	public void testLogIf_2() {
		LogUtil logger = new LogUtil("test", null);
		logger.setLevel(Level.ALL);
		logger.logIf(Level.FINEST, () -> false, () -> "NG");
	}
}
