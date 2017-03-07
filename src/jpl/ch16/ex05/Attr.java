/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch16.ex05;

import jpl.ch16.ex04.BugsFixed;

public class Attr {
	private final String name;
	private Object value = null;

	@BugsFixed ({"457605", "532456"})
	public Attr(String name) {
		this.name = name;
	}

	@BugsFixed ({"457605", "532456"})
	public Attr(String name, Object value) {
		this.name = name;
		this.value = value;
	}

	@BugsFixed ({"457605", "532456"})
	public String getName() {
		return name;
	}

	@BugsFixed ({"457605", "532456"})
	public Object getValue() {
		return value;
	}

	@BugsFixed ({"457605", "532456"})
	public Object setValue(Object newValue) {
		Object oldVal = value;
		value = newValue;
		return oldVal;
	}

	@BugsFixed ({"457605", "532456"})
	public String toString() {
		return name + "='" + value + "'";
	}
}
