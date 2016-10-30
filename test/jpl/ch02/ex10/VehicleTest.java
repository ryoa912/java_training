package jpl.ch02.ex10;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void testToString() {
		int idNum = 1;
		Vehicle obj = new Vehicle(idNum);
		obj.owner = "Brown";

		String str = obj.toString();

		if (str != null) {
			assertEquals("speed=0, angle=0, owner=Brown, id=1/1", str);
		}
	}
}
