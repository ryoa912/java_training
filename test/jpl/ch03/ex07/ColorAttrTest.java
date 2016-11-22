package jpl.ch03.ex07;

import static org.junit.Assert.*;

import org.junit.Test;

public class ColorAttrTest {

	@Test
	public void testEqualsObject() {
		ColorAttr obj = new ColorAttr("red", "255,0,0,0");

		assertEquals(true, obj.equals("255,0,0,0"));
	}


	@Test
	public void testHashCode() {
		ColorAttr obj = new ColorAttr("red", "255,0,0,0");

		assertEquals(obj.getValue().hashCode(), obj.hashCode());

	}
}
