/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch21.ex07;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class MyStack<E> {
	private List<E> list = new ArrayList<>();

	public void push(E element) {
		list.add(element);
	}

	public E pop() {
		if (list.isEmpty())
			throw new EmptyStackException();
		return list.remove(list.size() - 1);
	}
}
