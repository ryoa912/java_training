package jpl.ch13.ex04;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class StringUtilsTest {
	static final String str0 = "Boolean true\n";
	static final String str1 = "Boolean true\nCharacter a\n";
	static final String str2 = "Boolean true\nCharacter a\nCharacter b\n";
	static final String str3 = "Boolean true\nCharacter a\nCharacter b\nInteger 100\n";
	static final Object[] expected = {true, 'a', 'b', 100};

	@Test
	public void testDelimitedObjectArray_0() {
		List<Object> ret = StringUtils.delimitedObjectArray(str0);
		for (int i=0; i<ret.size(); i++) {
			assertEquals(expected[i], ret.get(i));
		}
	}
	@Test
	public void testDelimitedObjectArray_1() {
		List<Object> ret = StringUtils.delimitedObjectArray(str1);
		for (int i=0; i<ret.size(); i++) {
			assertEquals(expected[i], ret.get(i));
		}
	}
	@Test
	public void testDelimitedObjectArray_2() {
		List<Object> ret = StringUtils.delimitedObjectArray(str2);
		for (int i=0; i<ret.size(); i++) {
			assertEquals(expected[i], ret.get(i));
		}
	}
	@Test
	public void testDelimitedObjectArray_3() {
		List<Object> ret = StringUtils.delimitedObjectArray(str3);
		for (int i=0; i<ret.size(); i++) {
			assertEquals(expected[i], ret.get(i));
		}
	}
}
