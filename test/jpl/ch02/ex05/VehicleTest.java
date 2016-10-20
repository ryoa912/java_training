package jpl.ch02.ex05;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void testMain() {
		Vehicle obj = new Vehicle();
		obj.speed = 100;
		obj.angle = 30;
		obj.owner = "Michel";
		obj.idNumber = Vehicle.nextIdNumber++;

		obj.main(null);

		System.out.println("[目視確認]Vehicleのオブジェクトのフィールドの値が表示されていること。");
	}

	@Test
	public void testMain2() {
		Vehicle obj = new Vehicle();
		obj.speed = 80;
		obj.angle = 90;
		obj.owner = "Brown";
		obj.idNumber = Vehicle.nextIdNumber++;

		obj.main(null);

		System.out.println("[目視確認]Vehicleのオブジェクトのフィールドの値が表示されていること。");
	}

}
