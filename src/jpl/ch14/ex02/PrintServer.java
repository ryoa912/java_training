package jpl.ch14.ex02;

import java.awt.PrintJob;

public class PrintServer {
	private final PrintQueue requests = new PrintQueue();
	public PrintServer() {
		Runnable service = new Runnable() {
			public void run() {
				for(;;)
					realPrint(requests.remove());
			}
		};
		new Thread(service).start();
	}
	public void print(PrintJob job) {
		requests.add(job);
	}
	private void realPrint(PrintJob job) {
		//印刷の実際の処理を行う
		System.out.println(job.toString());
	}
}
