package jpl.ch03.ex08;

public class PassengerVehicle extends Vehicle implements Cloneable{
	public static final int SHEET_NUM = 4;
	public int passengers;

	public PassengerVehicle() {
	}

	public void setPassengers(int aPassengers) {
		passengers = aPassengers >= SHEET_NUM ? SHEET_NUM : aPassengers;
	}

	public int getPassengers() {
		return passengers;
	}

	public PassengerVehicle clone() throws CloneNotSupportedException {
		return (PassengerVehicle) super.clone();
	}
}
