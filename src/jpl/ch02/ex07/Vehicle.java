package jpl.ch02.ex07;

public class Vehicle {
	public int speed;
	public int angle;
	public String owner;
	private static int nextIdNumber;
	public int idNumber;

	public Vehicle() {
		idNumber = nextIdNumber++;
	}

	public Vehicle(String ownerName) {
		idNumber = nextIdNumber++;
		owner = ownerName;
	}

	public void main (String[] args) {
		System.out.println("Speed=" + speed + ", angle=" + angle + ", owner=" + owner);
		System.out.println("next ID Number=" + nextIdNumber + ", idNumber=" + idNumber);
	}
}
