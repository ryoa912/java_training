package jpl.ch02.ex18;

import static org.junit.Assert.*;

import org.junit.Test;

import mockit.Deencapsulation;

public class VehicleTest {

	@Test
	public void testMain_1() {
		String[] input = new String[1];

		input[0] = new String("Takashi");

		Vehicle obj = new Vehicle();

		obj.main(input);

		String actual_owner = Deencapsulation.getField(obj, "owner");
		int actual_id = Deencapsulation.getField(obj, "idNum");

		assertEquals("Takashi", actual_owner);
		assertEquals(1, actual_id);
	}

	@Test
	public void testMain_2() {
		String[] input = null;

		Vehicle obj = new Vehicle();

		obj.main(input);

		String actual_owner = Deencapsulation.getField(obj, "owner");
		int actual_id = Deencapsulation.getField(obj, "idNum");

		assertEquals(null, actual_owner);
		assertEquals(2, actual_id);
	}
}
