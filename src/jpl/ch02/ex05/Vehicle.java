package jpl.ch02.ex05;

public class Vehicle {
	public int speed;
	public int angle;
	public String owner;
	public static int nextIdNumber;
	public int idNumber;

	public void main (String[] args) {
		System.out.println("Speed=" + speed + ", angle=" + angle + ", owner=" + owner);
		System.out.println("next ID Number=" + nextIdNumber + ", idNumber=" + idNumber);
	}
}
