package jpl.ch01.ex14;

import static org.junit.Assert.*;

import org.junit.Test;

import mockit.Deencapsulation;

public class Walkman2Test {

	@Test
	public void testPlay1() {
		Walkman2 obj = new Walkman2();
		Deencapsulation.setField(obj, "terminal", true);
		Deencapsulation.setField(obj, "terminal2", true);

		Boolean result = obj.play();
		assertEquals(true, result);
	}

	@Test
	public void testPlay2() {
		Walkman2 obj = new Walkman2();
		Deencapsulation.setField(obj, "terminal", true);
		Deencapsulation.setField(obj, "terminal2", false);

		Boolean result = obj.play();
		assertEquals(true, result);
	}

	@Test
	public void testPlay3() {
		Walkman2 obj = new Walkman2();
		Deencapsulation.setField(obj, "terminal", false);
		Deencapsulation.setField(obj, "terminal2", true);

		Boolean result = obj.play();
		assertEquals(true, result);
	}

	@Test
	public void testPlay4() {
		Walkman2 obj = new Walkman2();
		Deencapsulation.setField(obj, "terminal", false);
		Deencapsulation.setField(obj, "terminal2", false);

		Boolean result = obj.play();
		assertEquals(false, result);
	}

	@Test
	public void testConnectTerminal2() {
		Walkman2 obj = new Walkman2();
		obj.connectTerminal2();

		Boolean actual = Deencapsulation.getField(obj, "terminal2");
		assertEquals(true, actual);
	}

	@Test
	public void testDisconnectTerminal2() {
		Walkman2 obj = new Walkman2();
		obj.disconnectTerminal2();

		Boolean actual = Deencapsulation.getField(obj, "terminal2");
		assertEquals(false, actual);
	}

}
