package jpl.ch04.ex01;

public class Battery implements EnergySource {
	public int energy;

	@Override
	public boolean empty() {
		System.out.println("energy=" + energy);
		return energy>=25 ? false : true;
	}

	@Override
	public void charge(int val) {
		energy += val;

	}

}
