package jpl.ch02.ex11;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void testToString() {
		String str1 = "first";
		String str2 = "second";
		LinkedList obj1 = new LinkedList(str1, null);
		LinkedList obj2 = new LinkedList(str2, obj1);

		String str = obj1.toString();

		if (str != null) {
			assertEquals("first, second", str);
		}
	}
}
