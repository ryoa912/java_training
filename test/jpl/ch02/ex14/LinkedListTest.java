package jpl.ch02.ex14;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void testGetObj() {
		LinkedList obj = new LinkedList("first", null);

		Object actual = obj.getObj();

		assertEquals("first", actual);
	}

	@Test
	public void testGetNext() {
		LinkedList obj1 = new LinkedList("first", null);
		LinkedList obj2 = new LinkedList("second", obj1);

		LinkedList actual = obj1.getNext();

		assertEquals("second", actual.getObj());
	}

}
