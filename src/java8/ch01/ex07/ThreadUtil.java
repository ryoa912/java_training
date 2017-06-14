/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch01.ex07;

public class ThreadUtil {
	public static Runnable andThen(Runnable r1, Runnable r2) {
        return () -> {
        	r1.run();
        	r2.run();
        };
    }
}
