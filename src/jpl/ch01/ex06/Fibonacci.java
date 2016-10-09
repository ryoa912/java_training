package jpl.ch01.ex06;

public class Fibonacci {
	static final String TITLE = "[Fibonacci numbers up to 50]";
	public static void main(String[] args) {
		System.out.println(TITLE);
		int lo = 1;
		int hi = 1;
		System.out.println(lo);
		while(hi < 50) {
			System.out.println(hi);
			hi = lo + hi;
			lo = hi - lo;
		}
	}
}
