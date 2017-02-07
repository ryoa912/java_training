package jpl.ch14.ex04;

public class MyThread {
	public static int addNum1 = 100;
	public static int addNum2 = 200;
	public static int delayTime1 = 300;
	public static int delayTime2 = 400;

	public MyThread(int addNum, int delayTime) {
		Runnable service = new Runnable() {
			public void run() {
				for (;;) {
					Number.addNum(addNum);
					System.out.println(Number.getNum());
					try {
						Thread.sleep(delayTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
						return;
					}
				}
			}
		};
		new Thread(service).start();
	}

	public static void main(String[] args) {
		new MyThread(addNum1, delayTime1);
		new MyThread(addNum2, delayTime2);
	}
}
