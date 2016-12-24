package jpl.ch09.ex02;

import static org.junit.Assert.*;

import org.junit.Test;

public class BitCounterTest {

	@Test
	public void testBitCount_maxValue() {
		int ans = BitCounter.bitCount(Integer.MAX_VALUE);
		assertEquals(31, ans);
	}
	@Test
	public void testBitCount_minValue() {
		int ans = BitCounter.bitCount(Integer.MIN_VALUE);
		assertEquals(1, ans);
	}
	@Test
	public void testBitCount_01() {
		int ans = BitCounter.bitCount(0x0003);
		assertEquals(2, ans);
	}

}
