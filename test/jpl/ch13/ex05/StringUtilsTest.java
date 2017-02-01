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

}
