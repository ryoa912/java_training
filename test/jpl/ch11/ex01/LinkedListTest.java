package jpl.ch11.ex01;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {
	static final String str1 = "first";
	static final String str2 = "second";
	static final Integer int1 = 0;
	static final Integer int2 = 1;
	@Test
	public void testLinkedList_String() {
		LinkedList<String> obj = new LinkedList<String>(str1, null);
	}
	@Test
	public void testLinkedList_Integer() {
		LinkedList<Integer> obj = new LinkedList<Integer>(int1, null);
	}

	@Test
	public void testGetObj_String() {
		LinkedList<String> obj = new LinkedList<String>(str1, null);
		String output = obj.getObj();
		assertEquals(str1, output);
	}
	@Test
	public void testGetObj_Integer() {
		LinkedList<Integer> obj = new LinkedList<Integer>(int1, null);
		Integer output = obj.getObj();
		assertEquals(int1, output);
	}

	@Test
	public void testSetObj_String() {
		LinkedList<String> obj = new LinkedList<String>(null, null);
		assertEquals(null, obj.getObj());
		obj.setObj(str1);
		assertEquals(str1, obj.getObj());
	}
	@Test
	public void testSetObj_Integer() {
		LinkedList<Integer> obj = new LinkedList<Integer>(null, null);
		assertEquals(null, obj.getObj());
		obj.setObj(int1);
		assertEquals(int1, obj.getObj());
	}

	@Test
	public void testGetNext_String() {
		LinkedList<String> obj1 = new LinkedList<String>(str1, null);
		LinkedList<String> obj2 = new LinkedList<String>(str2, obj1);
		LinkedList<String> output = obj1.getNext();
		assertEquals(obj2, output);
	}
	@Test
	public void testGetNext_Integer() {
		LinkedList<Integer> obj1 = new LinkedList<Integer>(int1, null);
		LinkedList<Integer> obj2 = new LinkedList<Integer>(int1, obj1);
		LinkedList<Integer> output = obj1.getNext();
		assertEquals(obj2, output);
	}

	@Test
	public void testLength_String() {
		LinkedList<String> obj1 = new LinkedList<String>(str1, null);
		LinkedList<String> obj2 = new LinkedList<String>(str2, obj1);
		int output = obj1.length();
		assertEquals(2, output);
	}
	@Test
	public void testLength_Integer() {
		LinkedList<Integer> obj1 = new LinkedList<Integer>(int1, null);
		LinkedList<Integer> obj2 = new LinkedList<Integer>(int2, obj1);
		int output = obj1.length();
		assertEquals(2, output);
	}

}
