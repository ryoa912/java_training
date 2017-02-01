package jpl.ch13.ex06;

import static org.junit.Assert.*;

import org.junit.Test;


public class StringUtilsTest {
	static final String str1 = "123456";
	static final String expected1 = "123<<456";

	@Test
	public void testInsertSpacer() {
		String ret = StringUtils.insertSpacer(str1, "<<", 3);
		assertEquals(expected1, ret);
	}

}
