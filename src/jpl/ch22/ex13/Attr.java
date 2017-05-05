/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch22.ex13;

public class Attr<V> {
	private final String name;
	private V value = null;

	public Attr(String name) {
		this.name = name;
	}

	public Attr(String name, V value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public V getValue() {
		return value;
	}

	public Object setValue(V newValue) {
		Object oldVal = value;
		value = newValue;
		return oldVal;
	}

	public String toString() {
		return name + "='" + value + "'";
	}
}
