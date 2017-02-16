package jpl.ch14.ex06;

public class MessageThread {
	public static int MAX_COUNT_15 = 15;
	public static int MAX_COUNT_7 = 7;
	private int f_time = 0;
	private int f_count = 1;

	public synchronized void message(int count)  throws InterruptedException {
		while (true) {
			wait();
			f_time++;
			if (f_time >= count) {
				System.out.println("No." + f_count + ": " + count + " seconds have passed.");
				f_time = 0;
				f_count++;
			}
		}
	}
	public synchronized void wakeup() {
		notifyAll();
	}
	public static void main (String[] args) {
		MessageThread mt1 = new MessageThread();
		MessageThread mt2 = new MessageThread();
		Runnable service1 = new Runnable() {
			public void run() {
				try {
					mt1.message(MAX_COUNT_15);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(service1).start();

		Runnable service2 = new Runnable() {
			public void run() {
				try {
					mt2.message(MAX_COUNT_7);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(service2).start();

		Runnable service3 = new Runnable() {
			public synchronized void run() {
				while(true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					mt1.wakeup();
					mt2.wakeup();
				}
			}
		};
		new Thread(service3).start();

	}
}
