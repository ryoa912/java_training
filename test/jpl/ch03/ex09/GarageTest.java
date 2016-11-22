package jpl.ch03.ex09;

import static org.junit.Assert.*;

import org.junit.Test;

public class GarageTest {

	@Test
	public void testClone() {
		Vehicle v1 = new Vehicle();
		Vehicle v2 = new Vehicle();
		v1.turn(0);
		v2.turn(0);

		Garage g1 = new Garage();
		g1.vehicles[0] = v1;
		g1.vehicles[1] = v2;

		//deep copy
		Garage g2 = g1.clone();

		//コピー後のVehicleのフィールドを変更する
		g2.vehicles[0].turn(90);
		g2.vehicles[1].turn(270);

		//コピー後のVehicleは変更されている
		assertEquals(90, g2.vehicles[0].angle);
		assertEquals(270, g2.vehicles[1].angle);

		//コピー前のVehicleはそのまま
		assertEquals(0, g1.vehicles[0].angle);
		assertEquals(0, g1.vehicles[1].angle);
	}

}
