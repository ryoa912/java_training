/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch02.ex07;

import static org.junit.Assert.*;

import java.util.stream.Stream;

import org.junit.Test;

public class MyMathTest {
	@Test
	public void testIsFinite_1() {
		assertTrue(MyMath.isFinite(Stream.of("foo", "bar")));
	}
	@Test
	public void testIsFinite_2() {
		assertFalse(MyMath.isFinite(Stream.generate(() -> "foo")));
	}
}
