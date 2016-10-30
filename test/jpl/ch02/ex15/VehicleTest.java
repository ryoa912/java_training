package jpl.ch02.ex15;

import static org.junit.Assert.*;

import org.junit.Test;

import mockit.Deencapsulation;

public class VehicleTest {

	@Test
	public void testChangeSpeed() {
		Vehicle obj = new Vehicle();
		obj.changeSpeed(100);

		int actual = Deencapsulation.getField(obj, "speed");

		assertEquals(100, actual);
	}

	@Test
	public void testStop() {
		Vehicle obj = new Vehicle();

		Deencapsulation.setField(obj, "speed", 100);

		obj.stop();

		int actual = Deencapsulation.getField(obj, "speed");

		assertEquals(0, actual);
	}

}
