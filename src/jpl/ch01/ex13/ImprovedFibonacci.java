package jpl.ch01.ex13;

public class ImprovedFibonacci {
	static final int MAX_INDEX = 9;

	public static void main(String[] args) {
		int lo=1, hi=1;
		String mark;

		System.out.printf(" 1: %4d%n", hi);
		for (int i=2; i <= MAX_INDEX; i++) {
			if (hi % 2 == 0)
				mark = "*";
			else
				mark = "";
			System.out.printf("%2d: %4d " + mark + "%n", i, hi);
			hi = lo + hi;
			lo = hi - lo;
		}
	}

}
