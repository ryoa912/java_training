package jpl.ch01.ex06;

import org.junit.Test;

public class FibonacciTest {

	@Test
	public void testMain() {
		Fibonacci.main(null);
		System.out.println("[目視確認]Fibonacci数列が50まで表示されていること");
	}

}
