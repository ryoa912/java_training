package jpl.ch03.ex06;

public class Battery extends EnergySource{
	public int energy;
	static final int EMPTY_LINE = 25;

	public boolean empty() {
		System.out.println("energy=" + energy);
		return energy < EMPTY_LINE;
	}

	public void charge(int val) {
		energy += val;
	}
}
