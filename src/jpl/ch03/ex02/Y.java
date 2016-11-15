package jpl.ch03.ex02;

public class Y extends X{
	protected int yMask = 0xff00;

	public Y() {
		System.out.printf("6 0x%04x 0x%04x 0x%04x%n", xMask, yMask, fullMask);
		fullMask |= yMask;
		System.out.printf("7 0x%04x 0x%04x 0x%04x%n", xMask, yMask, fullMask);
	}
}
