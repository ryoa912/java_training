package jpl.ch01.ex04;


public class SquareSeries {
	public static final int MAX_NUM = 50;

	public static void main (String[] args) {
		int num = 1, ans = 1;
		System.out.println("[Square series up to 50]");
		while (true) {
			ans = num * num;
			if (ans > MAX_NUM) {
				break;
			}
			System.out.println(ans);
			num++;
		}
	}
}
