package jpl.ch14.ex02;

import java.awt.PrintJob;

public class MyPrintServer implements Runnable{
	private final PrintQueue requests = new PrintQueue();
	private Thread creatorThread;
	public MyPrintServer() {
		new Thread(this).start();
		creatorThread = Thread.currentThread();
	}
	public void print(PrintJob job) {
		requests.add(job);
	}
	public void run() {
		if (Thread.currentThread() != creatorThread) {
			return;
		}
		for (;;)
			realPrint(requests.remove());
	}
	private void realPrint(PrintJob job) {
		//印刷の実際の処理を行う
		System.out.println(job.toString());
	}
}
