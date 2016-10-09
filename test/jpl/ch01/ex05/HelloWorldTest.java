package jpl.ch01.ex05;

import org.junit.Test;

public class HelloWorldTest {

	@Test
	public void testMain() {
		HelloWorld.main(null);
		System.out.println("[目視確認]Hello, world!と表示されていること");
	}

}
