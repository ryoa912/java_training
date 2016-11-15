package jpl.ch03.ex06;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void testStart_GasTank() {
		GasTank src = new GasTank();
		Vehicle obj = new Vehicle(src);

		boolean result = obj.start();

		assertEquals(true, result);
	}
	@Test
	public void testStart_Battery() {
		Battery src = new Battery();
		Vehicle obj = new Vehicle(src);

		boolean result = obj.start();

		assertEquals(true, result);
	}
}
