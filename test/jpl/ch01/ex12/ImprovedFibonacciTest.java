package jpl.ch01.ex12;

import static org.junit.Assert.*;

import org.junit.Test;

public class ImprovedFibonacciTest {

	@Test
	public void testMain() {
		ImprovedFibonacci.main(null);
		String[] expected = {"1", "1", "2", "3", "5", "8", "13", "21", "34"};
		for (int i=0; i < expected.length; i++) {
			assertEquals(expected[i], ImprovedFibonacci.strs[i]);
		}
	}

}
