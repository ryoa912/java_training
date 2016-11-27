package jpl.ch04.ex01;

public class GasTank implements EnergySource {
	public int gas;

	@Override
	public boolean empty() {
		System.out.println("gas=" + gas);
		return gas>=1 ? false : true;
	}

	@Override
	public void charge(int val) {
		gas += val;

	}

}
