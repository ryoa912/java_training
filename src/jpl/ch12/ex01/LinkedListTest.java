package jpl.ch12.ex01;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {
	static final String str1 = "first";
	static final String str2 = "second";
	static final String str3 = "third";
	static final String str4 = "forth";

	@Test
	public void testFind_1() {
		LinkedList<String> obj1 = new LinkedList<String>(str1, null);
		LinkedList<String> obj2 = new LinkedList<String>(str2, obj1);
		LinkedList<String> obj3 = new LinkedList<String>(str3, obj2);

		try {
			LinkedList<String> ret = obj1.find(str3);
			assertFalse(false);
		} catch (ObjectNotFoundException e) {
			assertEquals(str3, e.object.toString());
		}
	}

	@Test
	public void testFind_2() {
		LinkedList<String> obj1 = new LinkedList<String>(str1, null);
		LinkedList<String> obj2 = new LinkedList<String>(str2, obj1);
		LinkedList<String> obj3 = new LinkedList<String>(str3, obj2);

		try {
			LinkedList<String> ret = obj1.find(str4);
			assertFalse(false);
		} catch (ObjectNotFoundException e) {
			assertEquals(str4, e.object.toString());
		}
	}
}
