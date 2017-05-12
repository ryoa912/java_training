/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch14.ex09;

public class MyThread extends Thread {
	/**
	 * @param th
	 * @param string
	 */
	public MyThread(ThreadGroup th, String string) {
		super(th, string);
	}

	public void startPrintThread(ThreadGroup tg) {
		Runnable service2 = new Runnable() {
			public void run() {
				while(true) {
					print(tg);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

			public void print(ThreadGroup tg) {
				tg.list();
				int ac = tg.activeCount();
				Thread[] t = new Thread[ac];
				tg.enumerate(t);
				for (int i=0; i<t.length; i++) {
					System.out.println(t[i].toString());
				}
				int agc = tg.activeGroupCount();
				ThreadGroup[] th = new ThreadGroup[agc];
				tg.enumerate(th);
				for (int j=0; j<th.length; j++) {
					print(th[j]);
				}
			}
		};
		new Thread(service2).start();
	}

	public static void main(String[] args) {
		ThreadGroup th = new ThreadGroup("Thread group 1");
		Thread t1 = new Thread(th, "Thread1");
		t1.start();
		Thread t2 = new Thread(th, "Thread2");
		t2.start();
		MyThread mt = new MyThread(th, "MyThread");
		mt.startPrintThread(th);
	}
}
