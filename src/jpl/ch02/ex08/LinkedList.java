package jpl.ch02.ex08;

public class LinkedList {
	public Object obj;
	public LinkedList next;

	public LinkedList(Object object, LinkedList previous) {
		obj = object;
		if (null != previous)
			previous.next = this;
	}
}
