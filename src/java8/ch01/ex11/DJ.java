/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch01.ex11;

public interface DJ {
	default void f() {
		System.out.println("DJ.f()");
	}
}
