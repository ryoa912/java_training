package jpl.ch13.ex05;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilsTest {
	static final String str1 = "123456";
	static final String expected1 = "123,456";

	@Test
	public void testInsertComma() {
		String ret = StringUtils.insertComma(str1);
		assertEquals(expected1, ret);
	}
	@Test
	public void testInsertComma_2() {
		String input = "123";
		String expected = "123";
		String ret = StringUtils.insertComma(input);
		assertEquals(expected, ret);
	}
	@Test
	public void testInsertComma_0() {
		String input = "";
		String expected = "";
		String ret = StringUtils.insertComma(input);
		assertEquals(expected, ret);
	}

}
