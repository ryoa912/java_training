package jpl.ch09.ex04;

import org.junit.Test;

public class ConstantsCheckerTest {
	@Test
	public void testPrintConstants_1() {
		ConstantsChecker.printConstants(3 << 2L - 1);
	}
	@Test
	public void testPrintConstants_2() {
		ConstantsChecker.printConstants((3L << 2) -1);
	}
	@Test
	public void testPrintConstants_3() {
		ConstantsChecker.printConstants(10 < 12 == 6 > 17);
	}
	@Test
	public void testPrintConstants_4() {
		ConstantsChecker.printConstants(10 << 12 == 6 >> 17);
	}
	@Test
	public void testPrintConstants_5() {
		ConstantsChecker.printConstants(13.5e-1 % Float.POSITIVE_INFINITY);
	}
	@Test
	public void testPrintConstants_6() {
		ConstantsChecker.printConstants(Float.POSITIVE_INFINITY + Double.NEGATIVE_INFINITY);
	}
	@Test
	public void testPrintConstants_7() {
		ConstantsChecker.printConstants(Double.POSITIVE_INFINITY - Float.NEGATIVE_INFINITY);
	}
	@Test
	public void testPrintConstants_8() {
		ConstantsChecker.printConstants(0.0 / -0.0 == -0.0 / 0.0);
	}
	@Test
	public void testPrintConstants_9() {
		ConstantsChecker.printConstants(Integer.MAX_VALUE + Integer.MIN_VALUE);
	}
	@Test
	public void testPrintConstants_10() {
		ConstantsChecker.printConstants(Long.MAX_VALUE + 5);
	}
	@Test
	public void testPrintConstants_11() {
		ConstantsChecker.printConstants((short) 5 * (byte) 10);
	}
	@Test
	public void testPrintConstants_12() {
		int i=3;
		ConstantsChecker.printConstants((i < 15 ? 1.72e3f : 0));
	}
	@Test
	public void testPrintConstants_13() {
		int i = 3;
		ConstantsChecker.printConstants(i++ + i++ + --i);
	}

}
