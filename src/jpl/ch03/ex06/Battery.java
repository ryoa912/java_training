package jpl.ch03.ex06;

public class Battery extends EnergySource{
	public int energy;

	public boolean empty() {
		System.out.println("energy=" + energy);
		return energy>=25 ? false : true;
	}

	public void charge(int val) {
		energy += val;
	}
}
