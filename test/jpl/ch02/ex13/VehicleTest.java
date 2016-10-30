package jpl.ch02.ex13;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void testGetID() {
		Vehicle obj1 = new Vehicle();
		Vehicle obj2 = new Vehicle();
		Vehicle obj3 = new Vehicle();

		int id3 = obj3.getID();

		assertEquals(3, id3);
	}

}
