package jpl.ch02.ex07;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void testMain() {
		Vehicle obj = new Vehicle("Michel");
		obj.speed = 100;
		obj.angle = 30;

		obj.main(null);

		System.out.println("[目視確認]Vehicleのオブジェクトのフィールドの値が表示されていること。");
	}

	@Test
	public void testMain2() {
		Vehicle obj = new Vehicle("Brown");
		obj.speed = 80;
		obj.angle = 90;

		obj.main(null);

		System.out.println("[目視確認]Vehicleのオブジェクトのフィールドの値が表示されていること。");
	}
}
