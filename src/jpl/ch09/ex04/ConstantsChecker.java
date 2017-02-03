package jpl.ch09.ex04;

public class ConstantsChecker {
	//各型でオーバーロードしてコンパイラに呼び分けてもらう。
	static void printConstants(boolean arg) {
		System.out.println("[boolean]" + arg);
	}
	static void printConstants(char arg) {
		System.out.println("[char]" + arg);
	}
	static void printConstants(byte arg) {
		System.out.println("[byte]" + arg);
	}
	static void printConstants(short arg) {
		System.out.println("[short]" + arg);
	}
	static void printConstants(int arg) {
		System.out.println("[int]" + arg);
	}
	static void printConstants(long arg) {
		System.out.println("[long]" + arg);
	}
	static void printConstants(float arg) {
		System.out.println("[float]" + arg);
	}
	static void printConstants(double arg) {
		System.out.println("[double]" + arg);
	}
}
