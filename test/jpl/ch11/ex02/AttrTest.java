package jpl.ch11.ex02;

import static org.junit.Assert.*;

import org.junit.Test;

public class AttrTest {
	static final String str1 = "test";
	static final String str2 = "function";
	static final Integer int1 = Integer.MAX_VALUE;

	@Test
	public void testAttrString_1() {
		Attr<String> obj = new Attr<String>(str1);
	}
	@Test
	public void testAttrString_2() {
		Attr<Integer> obj = new Attr<Integer>(str1);
	}

	@Test
	public void testAttrStringE_1() {
		Attr<String> obj = new Attr<String>(str1, str2);
	}
	@Test
	public void testAttrStringE_2() {
		Attr<Integer> obj = new Attr<Integer>(str1, int1);
	}

	@Test
	public void testGetName_1() {
		Attr<String> obj = new Attr<String>(str1);
		assertEquals(str1, obj.getName());
	}
	@Test
	public void testGetName_2() {
		Attr<Integer> obj = new Attr<Integer>(str1);
		assertEquals(str1, obj.getName());
	}
	@Test
	public void testGetName_3() {
		Attr<String> obj = new Attr<String>(str1, str2);
		assertEquals(str1, obj.getName());
	}
	@Test
	public void testGetName_4() {
		Attr<Integer> obj = new Attr<Integer>(str1, int1);
		assertEquals(str1, obj.getName());
	}

	@Test
	public void testGetValue_1() {
		Attr<String> obj = new Attr<String>(str1);
		assertEquals(null, obj.getValue());
	}
	@Test
	public void testGetValue_2() {
		Attr<Integer> obj = new Attr<Integer>(str1);
		assertEquals(null, obj.getValue());
	}
	@Test
	public void testGetValue_3() {
		Attr<String> obj = new Attr<String>(str1, str2);
		assertEquals(str2, obj.getValue());
	}
	@Test
	public void testGetValue_4() {
		Attr<Integer> obj = new Attr<Integer>(str1, int1);
		assertEquals(int1, obj.getValue());
	}

	@Test
	public void testSetValue() {
		Attr<String> obj = new Attr<String>(str1);
		obj.setValue(str2);
		assertEquals(str2, obj.getValue());
	}
	@Test
	public void testSetValue_2() {
		Attr<Integer> obj = new Attr<Integer>(str1);
		obj.setValue(int1);
		assertEquals(int1, obj.getValue());
	}
	@Test
	public void testSetValue_3() {
		Attr<String> obj = new Attr<String>(str1, str2);
		obj.setValue(str2);
		assertEquals(str2, obj.getValue());
	}
	@Test
	public void testSetValue_4() {
		Attr<Integer> obj = new Attr<Integer>(str1, int1);
		obj.setValue(int1);
		assertEquals(int1, obj.getValue());
	}

	@Test
	public void testToString_1() {
		Attr<Integer> obj = new Attr<Integer>(str1);
		String output = obj.toString();
		assertEquals("test='null'", output);
	}
	@Test
	public void testToString_2() {
		Attr<Integer> obj = new Attr<Integer>(str1);
		String output = obj.toString();
		assertEquals("test='null'", output);
	}
	@Test
	public void testToString_3() {
		Attr<String> obj = new Attr<String>(str1, str2);
		String output = obj.toString();
		assertEquals("test='" + str2 + "'", output);
	}
	@Test
	public void testToString_4() {
		Attr<Integer> obj = new Attr<Integer>(str1, int1);
		String output = obj.toString();
		assertEquals("test='" + int1 + "'", output);
	}

}
