/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch01.ex05;

//コード行数は、無名クラスの1メソッドあたり2行減った。
//コードの読みやすさは変わらない。
//メソッド参照は使用していない。
public class MyFriendly1 {
	private MyFriendly1 partner;
	private String name;

	public MyFriendly1(String name) {
		this.name = name;
	}

	public synchronized void hug() {
		System.out.println(
				Thread.currentThread().getName()
				+ " in " + name + ".hug() trying to invoke "
				+ partner.name + ".hugBack()");
		partner.hugBack();
	}

	private synchronized void hugBack() {
		System.out.println(
				Thread.currentThread().getName()
				+ " in " + name + ".hugBack()");
	}

	public void becomeFriend(MyFriendly1 partner) {
		this.partner = partner;
	}

	public static void main(String[] args) {
		final MyFriendly1 jareth = new MyFriendly1("jareth");
		final MyFriendly1 cory = new MyFriendly1("cory");

		jareth.becomeFriend(cory);
		cory.becomeFriend(jareth);

		new Thread(() -> {
			while (true) jareth.hug();
		}, "Thread1").start();

		new Thread(() -> {
			while (true) cory.hug();
		}, "Thread2").start();
	}
}
