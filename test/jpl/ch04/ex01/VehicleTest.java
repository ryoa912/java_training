package jpl.ch04.ex01;

import static org.junit.Assert.*;

import org.junit.Test;

import jpl.ch03.ex06.Battery;
import jpl.ch03.ex06.GasTank;
import jpl.ch03.ex06.Vehicle;

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
