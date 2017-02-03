package jpl.ch09.ex04;

public class Constants {
	public static final void printConstant1() {
		System.out.println(3 << 2L - 1);
	}
	public static final void printConstant2() {
		System.out.println((3L << 2) -1);
	}
	public static final void printConstant3() {
		System.out.println(10 < 12 == 6 > 17);
	}
	public static final void printConstant4() {
		System.out.println(10 << 12 == 6 >> 17);
	}
	public static final void printConstant5() {
		System.out.println(13.5e-1 % Float.POSITIVE_INFINITY);
	}
	public static final void printConstant6() {
		System.out.println(Float.POSITIVE_INFINITY + Double.NEGATIVE_INFINITY);
	}
	public static final void printConstant7() {
		System.out.println(Double.POSITIVE_INFINITY - Float.NEGATIVE_INFINITY);
	}
	public static final void printConstant8() {
		System.out.println(0.0 / -0.0 == -0.0 / 0.0);
	}
	public static final void printConstant9() {
		System.out.println(Integer.MAX_VALUE + Integer.MIN_VALUE);
	}
	public static final void printConstant10() {
		System.out.println(Long.MAX_VALUE + 5);
	}
	public static final void printConstant11() {
		System.out.println((short) 5 * (byte) 10);
	}
	public static final void printConstant12() {
		int i = 3;
		System.out.println((i < 15 ? 1.72e3f : 0));
	}
	public static final void printConstant13() {
		int i = 3;
		System.out.println(i++ + i++ + --i);

		//式の型を正しく判定するには、
		//同じ名前のメソッドで、各型の引数を取るようにオーバーロードする。
		//判定したい式を渡すと、コンパイラが呼び分けてくれる。
	}
}
