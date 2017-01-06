package jpl.ch03.ex06;

public class GasTank extends EnergySource{
	public int gas;
	static final int EMPTY_LINE = 1;

	public boolean empty() {
		System.out.println("gas=" + gas);
		return gas < EMPTY_LINE;
	}

	public void charge(int val) {
		gas += val;
	}
}
