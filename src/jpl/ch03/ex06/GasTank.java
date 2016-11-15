package jpl.ch03.ex06;

public class GasTank extends EnergySource{
	public int gas;

	public boolean empty() {
		System.out.println("gas=" + gas);
		return gas>=1 ? false : true;
	}

	public void charge(int val) {
		gas += val;
	}
}
