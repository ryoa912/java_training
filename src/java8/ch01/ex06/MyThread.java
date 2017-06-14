/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch01.ex06;

public class MyThread {
	public interface RunnableEx {
        void run() throws Exception;
    }

    public static Runnable uncheck(RunnableEx runner) {
        return () -> {
            try {
                runner.run();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
}
}
