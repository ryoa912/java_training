package jpl.ch02.ex16;

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

	public int length() {
		int ret = 1;

		if (next != null) {
			ret += next.length();;
		}

		return ret;
	}
}
