package jpl.ch02.ex14;

public class LinkedList {
	private Object obj;
	private LinkedList next;

	public LinkedList(Object object, LinkedList previous) {
		obj = object;
		if (null != previous)
			previous.next = this;
	}

	public Object getObj() {
		return obj;
	}

	public LinkedList getNext() {
		return next;
	}
}
