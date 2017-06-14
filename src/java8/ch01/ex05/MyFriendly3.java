/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch01.ex05;

//コード行数は、無名クラスの1メソッドあたり2行減った。
//コードの読みやすさは変わらない。
//メソッド参照は使用していない。
public class MyFriendly3 {
	static final int JARETH_HUG_INTERVAL = 17;
	static final int CORY_HUG_INTERVAL = 13;
	private MyFriendly3 partner;
	private String name;

	//ハグをする権利を獲得した人のみハグ出来るようにする。これによりデッドロックは回避可能。
	static final String RIGHT_TO_HUG = "right to hug";

	public MyFriendly3(String name) {
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

	public void becomeFriend(MyFriendly3 partner) {
		this.partner = partner;
	}

	public static void main(String[] args) {
		final MyFriendly3 jareth = new MyFriendly3("jareth");
		final MyFriendly3 cory = new MyFriendly3("cory");

		jareth.becomeFriend(cory);
		cory.becomeFriend(jareth);

		new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(JARETH_HUG_INTERVAL);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized(RIGHT_TO_HUG) {
					jareth.hug();
				}
			}
		}, "Thread1").start();

		new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(CORY_HUG_INTERVAL);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized(RIGHT_TO_HUG) {
					cory.hug();
				}
			}
		}, "Thread2").start();
	}
}
