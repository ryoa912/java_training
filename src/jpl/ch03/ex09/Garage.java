package jpl.ch03.ex09;

public class Garage implements Cloneable{
	public static final int GARAGE_SIZE = 6;
	public Vehicle[] vehicles = new Vehicle[GARAGE_SIZE];

	public Garage clone() {
		try {
			Garage nObj = (Garage) super.clone();
			nObj.vehicles = vehicles.clone();
			return nObj;
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}
}
