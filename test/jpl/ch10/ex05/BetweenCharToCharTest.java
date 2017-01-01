package jpl.ch10.ex05;

import static org.junit.Assert.*;

import org.junit.Test;

public class BetweenCharToCharTest {

	@Test
	public void testPrintBetweenCharToChar_1() {
		String ret = BetweenCharToChar.printBetweenCharToChar('a', 'z');
		assertEquals("bcdefghijklmnopqrstuvwxy", ret);
	}

	@Test
	public void testPrintBetweenCharToChar_2() {
		String ret = BetweenCharToChar.printBetweenCharToChar('z', 'a');
		assertEquals("bcdefghijklmnopqrstuvwxy", ret);
	}

	@Test
	public void testPrintBetweenCharToChar_3() {
		String ret = BetweenCharToChar.printBetweenCharToChar('a', 'a');
		assertEquals("", ret);
	}

	@Test
	public void testPrintBetweenCharToChar_4() {
		String ret = BetweenCharToChar.printBetweenCharToChar('a', 'b');
		assertEquals("", ret);
	}

}
