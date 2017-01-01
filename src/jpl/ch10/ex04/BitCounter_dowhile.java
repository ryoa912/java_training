package jpl.ch10.ex04;

public class BitCounter_dowhile {
	public static final int bitCount(int n) {
		System.out.println("n: " + Integer.toBinaryString(n));
		int count = 0;
		int i = 0;
		do {		//for (int i=0; i<31; i++)
			int m = (int) Math.pow(2, i);
			System.out.println("m: " + Integer.toBinaryString(m));
			int ans = n | m;
			if (ans == n) {
				count++;
			}
			i++;
		} while ((i < 31));
		System.out.println("m: " + Integer.toBinaryString(Integer.MIN_VALUE));
		int ans = n | Integer.MIN_VALUE;
		if (ans == n) {
			count++;
		}
		System.out.println("count: " + count);
		return count;
	}
}
