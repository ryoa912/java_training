package jpl.ch13.ex02;

public class Counter {
	public final int countString(String src, String target) {
		int len = target.length();
		int count = 0;
		int s = 0;
		while (src.indexOf(target,s) != -1) {
			s = src.indexOf(target, s) + len;
			count++;
		}
		return count;
	}
}
