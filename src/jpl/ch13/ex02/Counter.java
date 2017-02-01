package jpl.ch13.ex02;

public class Counter {
	public final int countString(String src, String chr) {
		int len = chr.length();
		int count = 0;
		int s = 0;
		while (src.indexOf(chr,s) != -1) {
			s = src.indexOf(chr, s) + len;
			count++;
		}
		return count;
	}
}
