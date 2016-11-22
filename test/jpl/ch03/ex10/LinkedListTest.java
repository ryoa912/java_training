package jpl.ch03.ex10;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void testClone() {
		LinkedList obj1 = new LinkedList("first", null);
		LinkedList obj2 = new LinkedList("second", obj1);

		//deep copy
		LinkedList newObj1 = obj1.clone();
		LinkedList newObj2 = newObj1.getNext();

		//同じオブジェクトを参照しているかチェック
		obj2.setObj("zero");
		assertEquals("zero", (String) newObj2.getObj());
	}

}
