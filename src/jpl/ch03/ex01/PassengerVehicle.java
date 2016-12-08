package jpl.ch03.ex01;

public class PassengerVehicle extends Vehicle {
	public static final int SHEET_NUM = 4;
	public int passengers;

	public PassengerVehicle() {
		//superを呼ぶ
	}

	public void setPassengers(int aPassengers) {
		passengers = aPassengers >= SHEET_NUM ? SHEET_NUM : aPassengers;
	}

	public int getPassengers() {
		return passengers;
	}

	public void main(String[] args) {
		PassengerVehicle obj1 = new PassengerVehicle();
		obj1.setPassengers(1);
		System.out.println(obj1.getPassengers());

		PassengerVehicle obj2 = new PassengerVehicle();
		obj2.setPassengers(2);
		System.out.println(obj2.getPassengers());

		PassengerVehicle obj3 = new PassengerVehicle();
		obj3.setPassengers(3);
		System.out.println(obj3.getPassengers());

		PassengerVehicle obj4 = new PassengerVehicle();
		obj4.setPassengers(4);
		System.out.println(obj4.getPassengers());

		PassengerVehicle obj5 = new PassengerVehicle();
		obj2.setPassengers(5);
		System.out.println(obj5.getPassengers());
	}
}
