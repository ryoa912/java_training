package jpl.ch02.ex04;

public class Vehicle {
	public int speed;
	public int angle;
	public String owner;

	/* 次の車体の識別番号（static int nextIdNumber）はfinalとすべきではない。
	 * 理由としては、不変ではないため。 */
	public static int nextIdNumber;

	/* 自身の車体の識別番号（int idNumber）もfinalとすべきではない。
	 * 理由としては、基本的にはオブジェクト生成時に決まり不変だが、
	 * 場合によってはオブジェクト生成時に決定せず、かつ、変更される可能性があるため。
	 * ただし、外部からの操作により変更が加えられるようにする場合は、
	 * 管理者のみ実施できるようにアクセス制限をかけるべき。 */
	public int idNumber;

}
