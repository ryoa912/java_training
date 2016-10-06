package jpl.ch01.ex01;

import org.junit.Test;

public class HelloWorldTest {

	@Test
	public void testMain() {
		HelloWorld.main(null);
		System.out.println("[目視確認]Hello, worldと表示されていること");
	}

}
