package jpl.ch03.ex09;

public class Vehicle {
	private int speed;
	public int angle;
	private String owner;
	private int idNum;

	private static int nextID = 0;
	public enum EAngle {
		TURN_RIGHT,
		TURN_LEFT
	}
	public static final int ANGLE_RIGHT = 90;
	public static final int ANGLE_LEFT = 270;

	public Vehicle() {
		idNum = ++nextID;
	}

	public final int getID() {
		return idNum;
	}

	public void changeSpeed(int aSpeed) {
		speed = aSpeed;
	}

	public final void stop() {
		speed = 0;
	}

	public void turn(int aAngle) {
		angle = aAngle;
	}

	public void turn(EAngle aAngle) {
		switch (aAngle) {
		case TURN_RIGHT:
			angle = ANGLE_RIGHT;
			break;
		case TURN_LEFT:
			angle = ANGLE_LEFT;
			break;
		default:
			break;
		}
	}

	public void main (String[] args) {
		if (args ==null) {
			return;
		}
		if (args[0] != null) {
			this.owner = args[0];
		}
	}

	public Vehicle clone() throws CloneNotSupportedException {
		return (Vehicle) super.clone();
	}
}
