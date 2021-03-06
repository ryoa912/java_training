package jpl.ch03.ex06;

public class Vehicle {
	EnergySource src;
	public Vehicle(EnergySource aSrc) {
		src = aSrc;
	}

	public boolean start() {
		if (src == null) {
			return false;
		}
		while(true) {
			if (!src.empty()) {
				return true;
			}
			src.charge(1);
		}
	}
}
