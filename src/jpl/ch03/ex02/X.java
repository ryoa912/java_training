package jpl.ch03.ex02;

public class X {
	protected int xMask = 0x00ff;
	protected int fullMask;

	public X() {
		System.out.printf("4 0x%04x 0x%04x 0x%04x%n", xMask, 0, fullMask);
		fullMask = xMask;
		System.out.printf("5 0x%04x 0x%04x 0x%04x%n", xMask, 0, fullMask);
	}

	public int mask(int orig) {
		return (orig & fullMask);
	}

	public static void main(String[] args) {
		System.out.println("S xMask  yMask  fullMask");
		Y obj = new Y();
	}
}
