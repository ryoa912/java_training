/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch01.ex07;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ThreadUtilTest {
	@Test
	public void testAndThen() {
		String[] str = new String[2];
		ThreadUtil.andThen(() -> str[0] = "a", () -> str[1] = "b").run();
		assertEquals(Arrays.asList(str), Arrays.asList("a", "b"));
	}
}
