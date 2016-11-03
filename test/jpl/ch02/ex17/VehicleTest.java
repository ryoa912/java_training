package jpl.ch02.ex17;

import static org.junit.Assert.*;

import org.junit.Test;

import mockit.Deencapsulation;

public class VehicleTest {

	@Test
	public void testTurnInt_1() {
		Vehicle obj = new Vehicle();
		obj.turn(0);

		int actual = Deencapsulation.getField(obj, "angle");

		assertEquals(0, actual);
	}

	@Test
	public void testTurnInt_2() {
		Vehicle obj = new Vehicle();
		obj.turn(360);

		int actual = Deencapsulation.getField(obj, "angle");

		assertEquals(360, actual);
	}

	@Test
	public void testTurnEAngle_1() {
		Vehicle obj = new Vehicle();
		obj.turn(Vehicle.ANGLE_RIGHT);

		int actual = Deencapsulation.getField(obj, "angle");

		assertEquals(90, actual);
	}

	@Test
	public void testTurnEAngle_2() {
		Vehicle obj = new Vehicle();
		obj.turn(Vehicle.ANGLE_LEFT);

		int actual = Deencapsulation.getField(obj, "angle");

		assertEquals(270, actual);
	}
}
