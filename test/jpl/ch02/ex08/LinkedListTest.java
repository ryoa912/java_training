package jpl.ch02.ex08;

import static org.junit.Assert.*;

import org.junit.Test;

import jpl.ch02.ex07.Vehicle;

public class LinkedListTest {

	@Test
	public void testLinkedList() {
		Vehicle v1 = new Vehicle("Michel");
		LinkedList l1 = new LinkedList(v1, null);

		Vehicle v2 = new Vehicle("Brown");
		LinkedList l2 = new LinkedList(v2, l1);

		Object obj = l1.next.obj;
		Vehicle vehilce = (Vehicle) obj;

		assertEquals(vehilce.owner, "Brown");
	}

}
