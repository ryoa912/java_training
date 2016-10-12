package jpl.ch01.ex14;

import static org.junit.Assert.*;

import org.junit.Test;

import mockit.Deencapsulation;

public class WalkmanTest {

	@Test
	public void testPlay1() {
		Walkman obj = new Walkman();
		Deencapsulation.setField(obj, "terminal", true);

		Boolean result = obj.play();
		assertEquals(true, result);
	}

	@Test
	public void testPlay2() {
		Walkman obj = new Walkman();
		Deencapsulation.setField(obj, "terminal", false);

		Boolean result = obj.play();
		assertEquals(false, result);
	}

	@Test
	public void testConnectTerminal() {
		Walkman obj = new Walkman();
		obj.connectTerminal();

		Boolean actual = Deencapsulation.getField(obj, "terminal");
		assertEquals(true, actual);
	}

	@Test
	public void testDisconnectTerminal() {
		Walkman obj = new Walkman();
		obj.disconnectTerminal();

		Boolean actual = Deencapsulation.getField(obj, "terminal");
		assertEquals(false, actual);
	}

}
