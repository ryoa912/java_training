package jpl.ch02.ex16;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void testLength1() {
		LinkedList obj1 = new LinkedList("first", null);

		int actual = obj1.length();

		assertEquals(1, actual);
	}

	@Test
	public void testLength7() {
		LinkedList obj1 = new LinkedList("first", null);
		LinkedList obj2 = new LinkedList("second", obj1);
		LinkedList obj3 = new LinkedList("third", obj2);
		LinkedList obj4 = new LinkedList("third", obj3);
		LinkedList obj5 = new LinkedList("third", obj4);
		LinkedList obj6 = new LinkedList("third", obj5);
		LinkedList obj7 = new LinkedList("third", obj6);

		int actual = obj1.length();

		assertEquals(7, actual);
	}

}
