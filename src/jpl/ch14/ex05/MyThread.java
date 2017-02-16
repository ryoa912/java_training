package jpl.ch14.ex05;

public class MyThread {
	public static int addNum1 = 100;
	public static int addNum2 = 200;
	public static int subNum1 = 50;
	public static int subNum2 = 75;
	public static int delayTime1 = 300;
	public static int delayTime2 = 400;

	public MyThread(int addNum, int subNum, int delayTime) {
		Runnable service = new Runnable() {
			public void run() {
				for (;;) {
					//加算
					Number.addNum(addNum);
					System.out.println(Number.getNum());
					try {
						Thread.sleep(delayTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
						return;
					}
					//減算
					Number.subNum(addNum);
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
		new MyThread(addNum1, subNum1, delayTime1);
		new MyThread(addNum2, subNum2, delayTime2);
	}
}
