package jpl.ch02.ex11;

public class LinkedList {
	public Object obj;
	public LinkedList next;

	public LinkedList(Object object, LinkedList previous) {
		obj = object;
		if (null != previous)
			previous.next = this;
	}

	public String toString() {
		String ret = obj.toString();

		if (next != null) {
			ret += ", " + next.toString();
		}

		return ret;
	}
}
