/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch14.ex08;

//Thread.yield()を追加。ハグの回数に変化はあるか？⇒あまり無い
public class MyFriendly2 {
	static final int JARETH_HUG_INTERVAL = 17;
	static final int CORY_HUG_INTERVAL = 13;
	private MyFriendly2 partner;
	private String name;

	public MyFriendly2(String name) {
		this.name = name;
	}

	public synchronized void hug() {
		System.out.println(
				Thread.currentThread().getName()
				+ " in " + name + ".hug() trying to invoke "
				+ partner.name + ".hugBack()");
		//yieldをここに仕込んでみたが、デッドロックの起きる割合はほとんど変化なかった。
		Thread.yield();
		partner.hugBack();
	}

	private synchronized void hugBack() {
		System.out.println(
				Thread.currentThread().getName()
				+ " in " + name + ".hugBack()");
	}

	public void becomeFriend(MyFriendly2 partner) {
		this.partner = partner;
	}

	public static void main(String[] args) {
		final MyFriendly2 jareth = new MyFriendly2("jareth");
		final MyFriendly2 cory = new MyFriendly2("cory");

		jareth.becomeFriend(cory);
		cory.becomeFriend(jareth);

		new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(JARETH_HUG_INTERVAL);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					jareth.hug();
				}
			}
		}, "Thread1").start();

		new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(CORY_HUG_INTERVAL);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					cory.hug();
				}
			}
		}, "Thread2").start();
	}
}
