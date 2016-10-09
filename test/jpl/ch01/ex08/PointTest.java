package jpl.ch01.ex08;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {
	static final double ERROR_RANGE = 0.1;

	@Test
	public void testSetPoint() {
		Point testObj = new Point();

		Point input = new Point();
		input.x = 1.1;
		input.y = 1.2;

		testObj.setPoint(input);

		assertEquals(input.x, testObj.x, ERROR_RANGE);
		assertEquals(input.y, testObj.y, ERROR_RANGE);
	}

}
