package jpl.ch03.ex05;

public class NewCharBenchmark extends Benchmark {
	void benchmark() {
		char[] obj = new char[1];
	}

	public static void main(String[] args) {
		int count = 10000;
		long time = new NewCharBenchmark().repeat(count);
		System.out.println("[NewCharBenchmark] " + count + " methods in " + time + "nanoseconds.");
	}
}
