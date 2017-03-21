/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch18.ex01;

public class LinkedList {
	private Object obj;
	private LinkedList next;

	/**
	 * Creates a new LinkedList node with the given object and previous LinkedList node.
	 */
	public LinkedList(Object object, LinkedList previous) {
		obj = object;
		if (null != previous)
			previous.next = this;
	}

	/**
	 * Returns the LinkedList node's object.
	 */
	public Object getObj() {
		return obj;
	}

	/**
	 * Returns the next LinkedList node.
	 */
	public LinkedList getNext() {
		return next;
	}

	/**
	 * Returns the LinkedList length.
	 */
	public int length() {
		int ret = 1;

		if (next != null) {
			ret += next.length();;
		}

		return ret;
	}
}
