package jpl.ch13.ex03;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class StringUtilsTest {
	static final char start = '<';
	static final char end = '>';
	static final String str0 = "";
	static final String str1 = "<";
	static final String str2 = "<1";
	static final String str3 = "<1>";
	static final String str4 = "<1><";
	static final String str5 = "<1><2";
	static final String str6 = "<1><2>";
	static final String str10 = "<1><2><3><4><5><6><7><8><9><10>";
	static final String[] expected = {"<1>", "<2>", "<3>", "<4>", "<5>", "<6>", "<7>", "<8>", "<9>", "<10>"};

	@Test
	public void testDelimitedString_0() {
		String ret = StringUtils.delimitedString(str0, start, end);
		assertEquals(null, ret);
	}
	@Test
	public void testDelimitedString_1() {
		String ret = StringUtils.delimitedString(str1, start, end);
		assertEquals(null, ret);
	}
	@Test
	public void testDelimitedString_2() {
		String ret = StringUtils.delimitedString(str2, start, end);
		assertEquals(null, ret);
	}
	@Test
	public void testDelimitedString_3() {
		String ret = StringUtils.delimitedString(str3, start, end);
		assertEquals("<1>", ret);
	}
	@Test
	public void testDelimitedString_4() {
		String ret = StringUtils.delimitedString(str4, start, end);
		assertEquals("<1>", ret);
	}
	@Test
	public void testDelimitedString_5() {
		String ret = StringUtils.delimitedString(str5, start, end);
		assertEquals("<1>", ret);
	}
	@Test
	public void testDelimitedString_6() {
		String ret = StringUtils.delimitedString(str6, start, end);
		assertEquals("<1>", ret);
	}
	@Test
	public void testDelimitedString_10() {
		String ret = StringUtils.delimitedString(str10, start, end);
		assertEquals("<1>", ret);
	}

	@Test
	public void testDelimitedStringArray_0() {
		List<String> ret = StringUtils.delimitedStringArray(str0, start, end);
		//assertEquals(null, ret);
	}
	@Test
	public void testDelimitedStringArray_1() {
		List<String> ret = StringUtils.delimitedStringArray(str1, start, end);
		for (int i=0; i<ret.size(); i++) {
			assertEquals(expected[i], ret.get(i));
		}
	}
	@Test
	public void testDelimitedStringArray_2() {
		List<String> ret = StringUtils.delimitedStringArray(str2, start, end);
		for (int i=0; i<ret.size(); i++) {
			assertEquals(expected[i], ret.get(i));
		}
	}
	@Test
	public void testDelimitedStringArray_3() {
		List<String> ret = StringUtils.delimitedStringArray(str3, start, end);
		for (int i=0; i<ret.size(); i++) {
			assertEquals(expected[i], ret.get(i));
		}
	}
	@Test
	public void testDelimitedStringArray_4() {
		List<String> ret = StringUtils.delimitedStringArray(str4, start, end);
		for (int i=0; i<ret.size(); i++) {
			assertEquals(expected[i], ret.get(i));
		}
	}
	@Test
	public void testDelimitedStringArray_5() {
		List<String> ret = StringUtils.delimitedStringArray(str5, start, end);
		for (int i=0; i<ret.size(); i++) {
			assertEquals(expected[i], ret.get(i));
		}
	}
	@Test
	public void testDelimitedStringArray_6() {
		List<String> ret = StringUtils.delimitedStringArray(str6, start, end);
		for (int i=0; i<ret.size(); i++) {
			assertEquals(expected[i], ret.get(i));
		}
	}
	@Test
	public void testDelimitedStringArray_10() {
		List<String> ret = StringUtils.delimitedStringArray(str10, start, end);
		for (int i=0; i<ret.size(); i++) {
			assertEquals(expected[i], ret.get(i));
		}
	}
}
