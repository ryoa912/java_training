package jpl.ch02.ex09;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void testGetMaxIdNumber() {
		Vehicle v1 = new Vehicle(100);
		Vehicle v2 = new Vehicle(200);
		Vehicle v3 = new Vehicle(10);

		int maxIdNum = Vehicle.getMaxIdNumber();

		assertEquals(200, maxIdNum);
	}

}
