package jpl.ch02.ex17;

public class Vehicle {
	private int speed;
	public int angle;
	public String owner;
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

	public int getID() {
		return idNum;
	}

	public void changeSpeed(int aSpeed) {
		speed = aSpeed;
	}

	public void stop() {
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
}
