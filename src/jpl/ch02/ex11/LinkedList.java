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
		//再帰呼び出しの場合は、スタックオーバーフローに注意する。
		String ret = obj.toString();

		if (next != null) {
			ret += ", " + next.toString();
		}

		return ret;
	}
}
