package jpl.ch13.ex01;

import static org.junit.Assert.*;

import org.junit.Test;

public class CounterTest {
	static final char char1 = 'a';
	static final String str0 = "";
	static final String str1 = "a";
	static final String str2 = "ab";
	static final String str3 = "bba";
	static final String str10 = "abbbbabbba";

	@Test
	public void testCountChar_0() {
		Counter obj = new Counter();
		int result = obj.countChar(str0, char1);
		assertEquals(0, result);
	}
	@Test
	public void testCountChar_1() {
		Counter obj = new Counter();
		int result = obj.countChar(str1, char1);
		assertEquals(1, result);
	}
	@Test
	public void testCountChar_2() {
		Counter obj = new Counter();
		int result = obj.countChar(str2, char1);
		assertEquals(1, result);
	}
	@Test
	public void testCountChar_3() {
		Counter obj = new Counter();
		int result = obj.countChar(str3, char1);
		assertEquals(1, result);
	}
	@Test
	public void testCountChar_10() {
		Counter obj = new Counter();
		int result = obj.countChar(str10, char1);
		assertEquals(3, result);
	}

}
