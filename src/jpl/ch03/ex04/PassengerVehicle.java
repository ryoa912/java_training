package jpl.ch03.ex04;

public class PassengerVehicle extends Vehicle {
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
}
