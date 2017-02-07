package jpl.ch14.ex02;

import java.awt.PrintJob;
import java.util.Queue;

public class PrintQueue {
	private Queue<PrintJob> queue;
	public void add(PrintJob job) {
		queue.add(job);
	}

	public PrintJob remove() {
		return queue.remove();
	}

}
