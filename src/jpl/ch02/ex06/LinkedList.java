package jpl.ch02.ex06;

import jpl.ch02.ex05.Vehicle;

public class LinkedList {
	public Object obj;
	public LinkedList next;

	public void main(String[] args) {
		Vehicle v1 = new Vehicle();
		LinkedList l1 = new LinkedList();
		l1.obj = v1;

		Vehicle v2 = new Vehicle();
		LinkedList l2 = new LinkedList();
		l2.obj = v2;

		l1.next = l2;

	}
}
