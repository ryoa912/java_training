package jpl.ch06.ex02;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void testTurnInt_1() {
		Vehicle obj = new Vehicle();
		obj.turn(0);
		assertEquals(0, obj.angle);
	}

	@Test
	public void testTurnInt_2() {
		Vehicle obj = new Vehicle();
		obj.turn(360);
		assertEquals(360, obj.angle);
	}

	@Test
	public void testTurnEAngle_1() {
		Vehicle obj = new Vehicle();
		obj.turn(Vehicle.ANGLE_RIGHT);
		assertEquals(90, obj.angle);
	}

	@Test
	public void testTurnEAngle_2() {
		Vehicle obj = new Vehicle();
		obj.turn(Vehicle.ANGLE_LEFT);
		assertEquals(270, obj.angle);
	}

}
