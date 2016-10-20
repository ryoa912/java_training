package jpl.ch02.ex09;

public class Vehicle {
	public int speed;
	public int angle;
	public String owner;
	public int idNumber;

	private static int maxIdNumber;

	public Vehicle(int idNum) {
		idNumber = idNum;
		if (maxIdNumber < idNum) {
			maxIdNumber = idNum;
		}
	}

	static public int getMaxIdNumber() {
		return maxIdNumber;
	}
}
