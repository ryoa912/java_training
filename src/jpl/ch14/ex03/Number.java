package jpl.ch14.ex03;

public class Number {
	private int f_num = 0;
	public synchronized void addNum(int num) {
		f_num = f_num + num;
	}
	public synchronized int getNum() {
		return f_num;
	}
}
