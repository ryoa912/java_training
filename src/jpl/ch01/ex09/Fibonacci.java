package jpl.ch01.ex09;

public class Fibonacci {
	public static final int MAX_NUM = 50;

	static final String TITLE = "Fibonacci numbers up to " + MAX_NUM;

	public static void main(String[] args) {
		System.out.println(TITLE);

		int[] nums = new int[MAX_NUM];

		int index = 0;

		int lo = 1;
		int hi = 1;

		nums[index] = hi;
		index++;

		while(hi < MAX_NUM) {
			nums[index] = hi;
			index++;
			hi = lo + hi;
			lo = hi - lo;
		}

		for (int i=0; i<index; i++) {
			System.out.println(nums[i]);
		}
	}
}
