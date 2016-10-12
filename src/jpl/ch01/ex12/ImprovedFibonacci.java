package jpl.ch01.ex12;

public class ImprovedFibonacci {
	static final int MAX_INDEX = 9;

	public static String[] strs;

	public static void main(String[] args) {
		int lo=1, hi=1;
		strs = new String[MAX_INDEX];

		strs[0] = String.valueOf(hi);
		for (int i=1; i < MAX_INDEX; i++) {
			strs[i] = String.valueOf(hi);
			hi = lo + hi;
			lo = hi - lo;
		}
		return;
	}
}
