package jpl.ch13.ex01;

public class Counter {
	public final int  countChar(String src, char target) {
		int ret = 0;
		for (int i=0; i<src.length(); i++) {
			if (src.charAt(i) == target) {
				ret++;
			}
		}
		return ret;
	}
}
