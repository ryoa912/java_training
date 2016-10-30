package jpl.ch02.ex13;

public class Vehicle {
	public int speed;
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
}
