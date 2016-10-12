package jpl.ch01.ex14;

import static org.junit.Assert.*;

import org.junit.Test;

import mockit.Deencapsulation;

public class Walkman3Test {

	@Test
	public void testPlay1() {
		Walkman3 obj = new Walkman3();
		Deencapsulation.setField(obj, "terminal", true);
		Deencapsulation.setField(obj, "terminal2", true);
		Deencapsulation.setField(obj, "communicationMode", true);

		Boolean result = obj.play();
		assertEquals(true, result);
	}

	@Test
	public void testPlay2() {
		Walkman3 obj = new Walkman3();
		Deencapsulation.setField(obj, "terminal", true);
		Deencapsulation.setField(obj, "terminal2", true);
		Deencapsulation.setField(obj, "communicationMode", false);

		Boolean result = obj.play();
		assertEquals(true, result);
	}

	@Test
	public void testSetCommunicationMode1() {
		Walkman3 obj = new Walkman3();
		obj.setCommunicationMode(true);

		Boolean actual = Deencapsulation.getField(obj, "communicationMode");
		assertEquals(true, actual);
	}

	@Test
	public void testSetCommunicationMode2() {
		Walkman3 obj = new Walkman3();
		obj.setCommunicationMode(false);

		Boolean actual = Deencapsulation.getField(obj, "communicationMode");
		assertEquals(false, actual);
	}
}
