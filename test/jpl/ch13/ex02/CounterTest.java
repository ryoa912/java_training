package jpl.ch13.ex02;

import static org.junit.Assert.*;

import org.junit.Test;


public class CounterTest {
	static final String target = "test";
	static final String str0 = "";
	static final String str1 = "t";
	static final String str2 = "te";
	static final String str3 = "tes";
	static final String str4 = "test";
	static final String str5 = "testt";
	static final String str6 = "testte";
	static final String str7 = "testtes";
	static final String str8 = "testtest";
	static final String str9 = "testtestt";
	static final String str10 = "testtesttesttesttesttesttesttesttesttest";

	@Test
	public void testCountString_0() {
		Counter obj = new Counter();
		int result = obj.countString(str0, target);
		assertEquals(0, result);
	}
	@Test
	public void testCountString_1() {
		Counter obj = new Counter();
		int result = obj.countString(str1, target);
		assertEquals(0, result);
	}
	@Test
	public void testCountString_2() {
		Counter obj = new Counter();
		int result = obj.countString(str2, target);
		assertEquals(0, result);
	}
	@Test
	public void testCountString_3() {
		Counter obj = new Counter();
		int result = obj.countString(str3, target);
		assertEquals(0, result);
	}
	@Test
	public void testCountString_4() {
		Counter obj = new Counter();
		int result = obj.countString(str4, target);
		assertEquals(1, result);
	}
	@Test
	public void testCountString_5() {
		Counter obj = new Counter();
		int result = obj.countString(str5, target);
		assertEquals(1, result);
	}
	@Test
	public void testCountString_6() {
		Counter obj = new Counter();
		int result = obj.countString(str6, target);
		assertEquals(1, result);
	}
	@Test
	public void testCountString_7() {
		Counter obj = new Counter();
		int result = obj.countString(str7, target);
		assertEquals(1, result);
	}
	@Test
	public void testCountString_8() {
		Counter obj = new Counter();
		int result = obj.countString(str8, target);
		assertEquals(2, result);
	}
	@Test
	public void testCountString_9() {
		Counter obj = new Counter();
		int result = obj.countString(str9, target);
		assertEquals(2, result);
	}
	@Test
	public void testCountString_10() {
		Counter obj = new Counter();
		int result = obj.countString(str10, target);
		assertEquals(10, result);
	}
	@Test
	public void testCountString_aa() {
		Counter obj = new Counter();
		int result = obj.countString("aaaaa", "aa");
		assertEquals(4, result);
	}

}
