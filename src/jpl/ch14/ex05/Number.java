package jpl.ch14.ex05;

public class Number {
	private static int f_num = 0;
	public static synchronized void addNum(int num) {
		f_num = f_num + num;
	}
	public static synchronized int getNum() {
		return f_num;
	}
	public static void subNum(int num) {
		f_num = f_num - num;
	}
}
