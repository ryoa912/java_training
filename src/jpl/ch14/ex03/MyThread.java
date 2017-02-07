//Copyright © 2017 Ryoh Aruga
package jpl.ch14.ex03;

public class MyThread {
	public static int addNum1 = 100;
	public static int addNum2 = 200;
	public static int delayTime1 = 300;
	public static int delayTime2 = 400;

	public MyThread(Number obj, int addNum, int delayTime) {
		Runnable service = new Runnable() {
			public void run() {
				for (;;) {
					obj.addNum(addNum);
					System.out.println(obj.getNum());
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
		Number obj = new Number();
		new MyThread(obj, addNum1, delayTime1);
		new MyThread(obj, addNum2, delayTime2);

	}
}
