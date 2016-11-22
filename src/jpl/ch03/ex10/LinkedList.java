package jpl.ch03.ex10;

public class LinkedList implements Cloneable {
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

	public void setObj(Object obj) {
		this.obj = obj;
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

	public LinkedList clone() {
		try {
			LinkedList nObj = (LinkedList) super.clone();
			if (nObj.next != null)
				nObj.next.clone();
			return nObj;
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}
}
