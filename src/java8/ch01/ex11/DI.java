/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch01.ex11;

public interface DI {
	default void f() {
		System.out.println("DI.f()");
	}
}
