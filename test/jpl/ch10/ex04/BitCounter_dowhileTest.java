package jpl.ch10.ex04;

import static org.junit.Assert.*;

import org.junit.Test;

public class BitCounter_dowhileTest {

	@Test
	public void testBitCount_maxValue() {
		int ans = BitCounter_dowhile.bitCount(Integer.MAX_VALUE);
		assertEquals(31, ans);
	}
	@Test
	public void testBitCount_minValue() {
		int ans = BitCounter_dowhile.bitCount(Integer.MIN_VALUE);
		assertEquals(1, ans);
	}
	@Test
	public void testBitCount_01() {
		int ans = BitCounter_dowhile.bitCount(0x0003);
		assertEquals(2, ans);
	}

}
