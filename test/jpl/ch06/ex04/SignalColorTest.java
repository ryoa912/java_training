package jpl.ch06.ex04;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class SignalColorTest {

	@Test
	public void testGetColor_Red() {
		Color ret = SignalColor.RED.getColor();
		assertEquals(Color.red, ret);
	}

	@Test
	public void testGetColor_Yellow() {
		Color ret = SignalColor.YELLOW.getColor();
		assertEquals(Color.yellow, ret);
	}

	@Test
	public void testGetColor_Blue() {
		Color ret = SignalColor.BLUE.getColor();
		assertEquals(Color.blue, ret);
	}

}
