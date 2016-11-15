package jpl.ch03.ex01;

import static org.junit.Assert.*;

import org.junit.Test;

public class PassengerVehicleTest {

	@Test
	public void testPassengerVehicle_1() {
		PassengerVehicle obj = new PassengerVehicle();
		obj.setPassengers(1);
		assertEquals(1, obj.getPassengers());
	}

	@Test
	public void testPassengerVehicle_2() {
		PassengerVehicle obj = new PassengerVehicle();
		obj.setPassengers(2);
		assertEquals(2, obj.getPassengers());
	}

	@Test
	public void testPassengerVehicle_4() {
		PassengerVehicle obj = new PassengerVehicle();
		obj.setPassengers(4);
		assertEquals(4, obj.getPassengers());
	}

	@Test
	public void testPassengerVehicle_5() {
		PassengerVehicle obj = new PassengerVehicle();
		obj.setPassengers(5);
		assertEquals(4, obj.getPassengers());
	}
}
