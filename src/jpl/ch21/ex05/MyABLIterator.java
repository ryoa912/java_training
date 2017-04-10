/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch21.ex05;

import java.util.ListIterator;

public class MyABLIterator<E> implements ListIterator<E> {
	private int off;
	private int array;
	private int pos;

	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public E next() {
		return null;
	}

	@Override
	public boolean hasPrevious() {
		return false;
	}

	@Override
	public E previous() {
		return null;
	}

	@Override
	public int nextIndex() {
		return 0;
	}

	@Override
	public int previousIndex() {
		return 0;
	}

	@Override
	public void remove() {
	}

	@Override
	public void set(E e) {
	}

	@Override
	public void add(E e) {
	}
}
