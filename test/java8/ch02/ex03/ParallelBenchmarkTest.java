/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch02.ex03;

import java.io.IOException;
import java.nio.file.Paths;

import org.junit.Test;

public class ParallelBenchmarkTest {
	private static final int THRESHOULD = 12;

	@Test
	public void testRun() throws IOException {
		ParallelBenchmark.run(Paths.get("test/java8/ch02/ex03/war_and_peace.txt"), THRESHOULD);
	}

}
