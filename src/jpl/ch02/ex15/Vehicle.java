package jpl.ch02.ex15;

public class Vehicle {
	private int speed;
	public int angle;
	public String owner;
	private int idNum;

	private static int nextID = 0;

	public Vehicle() {
		idNum = ++nextID;
	}

	public int getID() {
		return idNum;
	}

	public void changeSpeed(int aSpeed) {
		speed = aSpeed;
	}

	public void stop() {
		speed = 0;
	}
}
