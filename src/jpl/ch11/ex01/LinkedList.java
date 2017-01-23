package jpl.ch11.ex01;

public class LinkedList<E> {
	private E obj;
	private LinkedList<E> next;

	public LinkedList(E object, LinkedList<E> previous) {
		obj = object;
		if (null != previous)
			previous.next = this;
	}

	public E getObj() {
		return obj;
	}

	public void setObj(E obj) {
		this.obj = obj;
	}

	public LinkedList<E> getNext() {
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
