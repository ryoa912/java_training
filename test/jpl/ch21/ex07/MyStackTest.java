/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch21.ex07;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyStackTest {
	@Test
	public void testPush_1() {
		MyStack<String> obj = new MyStack<>();
		String s1 = new String("first");
		obj.push(s1);

		assertEquals(s1, obj.pop());
	}

	@Test
	public void testPush_2() {
		MyStack<String> obj = new MyStack<>();
		String s1 = new String("first");
		String s2 = new String("second");
		obj.push(s1);
		obj.push(s2);

		assertEquals(s2, obj.pop());
		assertEquals(s1, obj.pop());
	}
}
